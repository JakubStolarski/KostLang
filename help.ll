declare i32 @printf(i8*, ...)
declare i32 @sprintf(i8*, i8*, ...)
declare i8* @strcpy(i8*, i8*)
declare i8* @strcat(i8*, i8*)
declare i32 @atoi(i8*)
declare i32 @__isoc99_scanf(i8*, ...)
declare void @llvm.memcpy.p0i8.p0i8.i64(i8* noalias nocapture writeonly, i8* noalias nocapture readonly, i64, i1 immarg)
@strps = constant [4 x i8] c"%s\0A\00"
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [5 x i8] c"%10s\00"
@strspi = constant [3 x i8] c"%d\00"
@str1 = constant [2 x i8] c"a\00"
@str2 = constant [2 x i8] c"b\00"
define i32 @main() nounwind{
%str1 = alloca [2 x i8]
%1 = bitcast [2 x i8]* %str1 to i8*
call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 1 %1, i8* align 1 getelementptr inbounds ([2 x i8], [2 x i8]* @str1, i32 0, i32 0), i64 2, i1 false)
%ptrstr1 = alloca i8*
%2 = getelementptr inbounds [2 x i8], [2 x i8]* %str1, i64 0, i64 0
store i8* %2, i8** %ptrstr1
%str2 = alloca [2 x i8]
%3 = bitcast [2 x i8]* %str2 to i8*
call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 1 %3, i8* align 1 getelementptr inbounds ([2 x i8], [2 x i8]* @str2, i32 0, i32 0), i64 2, i1 false)
%ptrstr2 = alloca i8*
%4 = getelementptr inbounds [2 x i8], [2 x i8]* %str2, i64 0, i64 0
store i8* %4, i8** %ptrstr2
%str3 = alloca [3 x i8]
%ptrstr3 = alloca i8*
%5 = getelementptr inbounds [3 x i8], [3 x i8]* %str3, i64 0, i64 0
store i8* %5, i8** %ptrstr3
%6 = load i8*, i8** %ptrstr3
%7 = call i8* @strcpy(i8* %6, i8* %1)
%8 = call i8* @strcat(i8* %7, i8* %3)
%b = alloca i8*
store i8* %8, i8** %b
%9 = load i8*, i8** %b
%10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strps, i32 0, i32 0), i8* %9)
ret i32 0 }

