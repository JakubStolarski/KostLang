import java.util.Stack;

class LLVMGenerator{
   
   static String header_text = "";
   static String main_text = "";
   static String buffer = "";
   static int reg = 1;
   static int main_reg = 1;
   static int str = 1;
   static int br = 0;

   static Stack<Integer> brstack = new Stack<Integer>();

   static void functionstart_1(String id, String type){
      main_text += buffer;
      main_reg = reg;
      buffer = "define " + type + " @"+id+"(";
      reg = 1;
   }

   static void functionstart_2(String id, String type){
      main_text += buffer;
      main_reg = reg;
      buffer = "define " + type + " @"+id+"(";
      reg = 1;
   }

   static void functionstart_end(){
      buffer += ") nounwind {\n";
   }

   static void functionstart_params(String id, String type){
      buffer += type + " %" + id + ", ";

   }

   static void ret_i32(String id){
      buffer += "ret i32 "+id;
   }

   static void ret_double(String id){
      buffer += "ret double "+id;
   }

   static void functionend(){
      buffer += "}\n";
      header_text += buffer;
      buffer = "";
      reg = main_reg;
   }

   static void icmp(String v1, String v2, String predicate){
      buffer += "%"+reg+" = icmp "+predicate+" i32 "+v1+", "+v2+"\n";
      reg++;
   }

   static void fcmp(String v1, String v2, String predicate){
      buffer += "%"+reg+" = fcmp "+predicate+" double "+v1+", "+v2+"\n";
      reg++;
   }

   static void ifstart(){
      br++;
      buffer += "br i1 %"+(reg-1)+", label %true"+br+", label %false"+br+"\n";
      buffer += "true"+br+":\n";
      brstack.push(br);
   }

   static void ifend(){
      int b = brstack.pop();
      brstack.push(br);
      buffer += "br label %exit"+b+"\n";
      buffer += "false"+b+":\n";
   }

   static void endelse(){
      int b = brstack.pop();
      buffer += "br label %exit"+b+"\n";
      buffer += "exit"+b+":\n";
   }

   static void whilelabel(){
      br++;
      buffer += "br label %br" + br + "\n";
      buffer += "br" + br + ":\n";
   }

   static void whilestart(){
      buffer += "br i1 %"+(reg-1)+", label %true"+br+", label %false"+br+"\n";
      buffer += "true"+br+":\n";
      brstack.push(br);
   }

   static void whileexit(){
      int b = brstack.pop();
      buffer += "br label %br"+b+"\n";
      buffer += "false"+b+":\n";
   }

   static void printf_string(String id, Boolean global){
      if (global){
         buffer += "%"+reg+" = load i8*, i8** @"+id+"\n";
      }
      else{
         buffer += "%"+reg+" = load i8*, i8** %"+id+"\n";
      }
      reg++;      
      buffer += "%"+reg+" = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strps, i32 0, i32 0), i8* %"+(reg-1)+")\n";
      reg++;
   }

   static void printf_i32(String id, Boolean global){
      if (global){
         buffer += "%"+reg+" = load i32, i32* @"+id+"\n";
      }
      else{
         buffer += "%"+reg+" = load i32, i32* %"+id+"\n";
      }
      
      reg++;
      buffer += "%"+reg+" = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %"+(reg-1)+")\n";
      reg++;
   }

   static void printf_bool(String id, Boolean global){
      if (global){
         buffer += "%"+reg+" = load i8, i8* @"+id+"\n";
      }
      else{
         buffer += "%"+reg+" = load i8, i8* %"+id+"\n";
      }
      
      reg++;
      buffer += "%"+reg+" = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i8 %"+(reg-1)+")\n";
      reg++;
   }

      static void printf_double(String id, Boolean global){
      if (global){
         buffer += "%"+reg+" = load double, double* @"+id+"\n";  
      }
      else{
         buffer += "%"+reg+" = load double, double* %"+id+"\n";
      }
      
      reg++;
      buffer += "%"+reg+" = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %"+(reg-1)+")\n";
      reg++;
   }

   static void scanf(String id, int l){
      allocate_string("str"+str, l);
      buffer += "%"+id+" = alloca i8*\n";
      buffer += "%"+reg+" = getelementptr inbounds ["+(l+1)+" x i8], ["+(l+1)+" x i8]* %str"+str+", i64 0, i64 0\n";
      reg++;
      buffer += "store i8* %"+(reg-1)+", i8** %"+id+"\n"; 
      str++;
      buffer += "%"+reg+" = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @strs, i32 0, i32 0), i8* %"+(reg-1)+")\n";
      reg++;
   }

   static void declare_i32(String id, Boolean global){
      if(global){
         header_text += "@"+id+" = global i32 0\n";
      }
      else{
         buffer += "%"+id+" = alloca i32\n";
      }
   }

   static void declare_double(String id, Boolean global){
      if(global){
         header_text += "@"+id+" = global double 0.0\n";
      }
      else{
         buffer += "%"+id+" = alloca double\n";
      }
   }

   static void declare_bool(String id, Boolean global){
      if(global){
         header_text += "@"+id+" = global i8 0\n";
      }
      buffer += "%"+id+" = alloca i8\n";
   }

   static void declare_string(String id, Boolean global){
      if(global){
         header_text += "@"+id+" = global i8* 0\n";
      }
      buffer += "%"+id+" = alloca i8*\n";
   }

   static void allocate_string(String id, int l){
      buffer += "%"+id+" = alloca ["+(l+1)+" x i8]\n";
   }

   static void assign_i32(String id, String value, Boolean global){
      if (global){
         buffer += "%"+reg+" = load i32, i32* @"+id+"\n";
         reg++;
         buffer += "store i32 " +value+", i32* @"+id+"\n";
      }
      else{
         buffer += "store i32 "+value+", i32* %"+id+"\n";
      }
   }

   static void assign_double(String id, String value, Boolean global){
      if (global){
         buffer += "%"+reg+" = load double, double* @"+id+"\n";
         reg++;
         buffer += "store double " +value+", double* @"+id+"\n";
      }
      else{
      buffer += "store double "+value+", double* %"+id+"\n";
      }
   }

   static void assign_string(String id){  
      buffer += "store i8* %"+(reg-1)+", i8** %"+id+"\n";
   }

   static void assign_bool(String id, String value){  
      buffer += "store i8 "+value+", i8* %"+id+"\n";
   }

   static void constant_string(String content){
      int l = content.length()+1;     
      header_text += "@str"+str+" = constant ["+l+" x i8] c\""+content+"\\00\"\n";
      String n = "str"+str;
      LLVMGenerator.allocate_string(n, (l-1));
      buffer += "%"+reg+" = bitcast ["+l+" x i8]* %"+n+" to i8*\n";
      buffer += "call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 1 %"+reg+", i8* align 1 getelementptr inbounds (["+l+" x i8], ["+l+" x i8]* @"+n+", i32 0, i32 0), i64 "+l+", i1 false)\n";
      reg++;
      buffer += "%ptr"+n+" = alloca i8*\n";
      buffer += "%"+reg+" = getelementptr inbounds ["+l+" x i8], ["+l+" x i8]* %"+n+", i64 0, i64 0\n";
      reg++;
      buffer += "store i8* %"+(reg-1)+", i8** %ptr"+n+"\n";    
      str++;
   }
   
   static void load_i32(String id, Boolean global){
      if (global){
         buffer += "%"+reg+" = load i32, i32* @"+id+"\n";
      }
      else{
         buffer += "%"+reg+" = load i32, i32* %"+id+"\n";
      }
      reg++;
   }

   static void load_double(String id, Boolean global){
      if(global){
         buffer += "%"+reg+" = load double, double* @"+id+"\n";
      }
      else{
         buffer += "%"+reg+" = load double, double* %"+id+"\n";
      }
      reg++;
   }

   static void load_string(String id, Boolean global){
      if(global){
         buffer += "%"+reg+" = load i8*, i8** @"+id+"\n";
      }
      else{
         buffer += "%"+reg+" = load i8*, i8** %"+id+"\n";
      }

      reg++;
   }

   static void load_bool(String id, Boolean global){
      if(global){
         buffer += "%"+reg+" = load i8, i8* @"+id+"\n";
      }
      else{
      buffer += "%"+reg+" = load i8, i8* %"+id+"\n";
      }

      reg++;
   }

   static void add_i32(String val1, String val2){
      buffer += "%"+reg+" = add i32 "+val1+", "+val2+"\n";
      reg++;
   }

   static void add_double(String val1, String val2){
      buffer += "%"+reg+" = fadd double "+val1+", "+val2+"\n";
      reg++;
   }

   static void add_string(String id1, int l1, String id2, int l2){
      allocate_string("str"+str, l1+l2);
      buffer += "%ptrstr"+str+" = alloca i8*\n";
      buffer += "%"+reg+" = getelementptr inbounds ["+(l1+l2+1)+" x i8], ["+(l1+l2+1)+" x i8]* %str"+str+", i64 0, i64 0\n";
      reg++;
      buffer += "store i8* %"+(reg-1)+", i8** %ptrstr"+str+"\n";
      buffer += "%"+reg+" = load i8*, i8** %"+id1+"\n";
      reg++;
      buffer += "%"+reg+" = load i8*, i8** %"+id2+"\n";
      reg++; 
      buffer += "%"+reg+" = load i8*, i8** %ptrstr"+str+"\n";
      reg++;  
      buffer += "%"+reg+" = call i8* @strcpy(i8* %"+(reg-1)+", i8* %"+(reg-3)+")\n";
      reg++;
      buffer += "%"+reg+" = call i8* @strcat(i8* %"+(reg-1)+", i8* %"+(reg-3)+")\n";
      reg++;
      str++;      
   }

   static void sub_i32(String val1, String val2){
      buffer += "%"+reg+" = sub i32 "+val1+", "+val2+"\n";
      reg++;
   }

      static void sub_double(String val1, String val2){
      buffer += "%"+reg+" = fsub double "+val1+", "+val2+"\n";
      reg++;
   }

      static void mult_i32(String val1, String val2){
      buffer += "%"+reg+" = mul i32 "+val1+", "+val2+"\n";
      reg++;
   }

   static void mult_double(String val1, String val2){
      buffer += "%"+reg+" = fmul double "+val1+", "+val2+"\n";
      reg++;
   }

      static void div_i32(String val1, String val2){
      buffer += "%"+reg+" = sdiv i32 "+val1+", "+val2+"\n";
      reg++;
   }

   static void div_double(String val1, String val2){
      buffer += "%"+reg+" = fdiv double "+val1+", "+val2+"\n";
      reg++;
   }

   static void call(String id, String type){
      buffer += "%"+reg+" = call " + type + " @" + id + "(";
      reg++;
   }

   static void call_params(String id, String type){
      buffer += type + " %" + id + ", ";

   }

   static void close_call(){
      buffer += ")\n";
   }

   static void close_main(){
      main_text += buffer;
   }
   static String generate(){
      String text = "";
      text += "declare i32 @printf(i8*, ...)\n";
      text += "declare i8* @strcpy(i8*, i8*)\n";
      text += "declare i8* @strcat(i8*, i8*)\n";
      text += "declare i32 @__isoc99_scanf(i8*, ...)\n";
      text += "declare void @llvm.memcpy.p0i8.p0i8.i64(i8* noalias nocapture writeonly, i8* noalias nocapture readonly, i64, i1 immarg)\n";
      text += "@strps = constant [4 x i8] c\"%s\\0A\\00\"\n";
      text += "@strpi = constant [4 x i8] c\"%d\\0A\\00\"\n";
      text += "@strpd = constant [4 x i8] c\"%f\\0A\\00\"\n";
      text += "@strs = constant [5 x i8] c\"%10s\\00\"\n";
      text += header_text;
      text += "define i32 @main() nounwind{\n";
      text += main_text;
      text += "ret i32 0 }\n";
      return text;
   }

}
