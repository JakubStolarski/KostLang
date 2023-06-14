declare i32 @printf(i8*, ...)
declare i8* @strcpy(i8*, i8*)
declare i8* @strcat(i8*, i8*)
declare i32 @__isoc99_scanf(i8*, ...)
declare void @llvm.memcpy.p0i8.p0i8.i64(i8* noalias nocapture writeonly, i8* noalias nocapture readonly, i64, i1 immarg)
@strps = constant [4 x i8] c"%s\0A\00"
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [5 x i8] c"%10s\00"
@str1 = constant [6 x i8] c"hello\00"
@str2 = constant [6 x i8] c"world\00"
define i32 @hello(i32* %a) nounwind {
%str1 = alloca [6 x i8]
%1 = bitcast [6 x i8]* %str1 to i8*
call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 1 %1, i8* align 1 getelementptr inbounds ([6 x i8], [6 x i8]* @str1, i32 0, i32 0), i64 6, i1 false)
%ptrstr1 = alloca i8*
%2 = getelementptr inbounds [6 x i8], [6 x i8]* %str1, i64 0, i64 0
store i8* %2, i8** %ptrstr1
%hello = alloca i8*
store i8* %2, i8** %hello
%str2 = alloca [6 x i8]
%3 = bitcast [6 x i8]* %str2 to i8*
call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 1 %3, i8* align 1 getelementptr inbounds ([6 x i8], [6 x i8]* @str2, i32 0, i32 0), i64 6, i1 false)
%ptrstr2 = alloca i8*
%4 = getelementptr inbounds [6 x i8], [6 x i8]* %str2, i64 0, i64 0
store i8* %4, i8** %ptrstr2
%world = alloca i8*
store i8* %4, i8** %world
br label %br1
br1:
%5 = load i32, i32* %a
%6 = icmp slt i32 %5, 3
br i1 %6, label %true1, label %false1
true1:
%7 = load i8*, i8** %hello
%8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strps, i32 0, i32 0), i8* %7)
%9 = load i32, i32* %a
%10 = add i32 %9, 1
store i32 %10, i32* %a
br label %br1
false1:
%11 = load i32, i32* %a
%12 = icmp slt i32 %11, 3
br i1 %12, label %true2, label %false2
true2:
%13 = load i8*, i8** %hello
%14 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strps, i32 0, i32 0), i8* %13)
br label %exit2
false2:
%15 = load i8*, i8** %world
%16 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strps, i32 0, i32 0), i8* %15)
br label %exit2
exit2:
%17 = load i32, i32* %a
%18 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %17)
ret i32 0}
define double @square(double* %e) nounwind {
%1 = load double, double* %e
%2 = load double, double* %e
%3 = fmul double %1, %2
%f = alloca double
store double %3, double* %f
%4 = load double, double* %f
ret double %4}
@b = global i32 0
@g = global double 0.0
define i32 @main() nounwind{
%1 = load i32, i32* @b
store i32 1, i32* @b
%2 = load i32, i32* @b
%helper1 = alloca i32
store i32 %2, i32* %helper1
%3 = call i32 @hello(i32* %helper1)
%4 = load i32, i32* @b
%5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %4)
%helper2 = alloca double
store double 5.0, double* %helper2
%6 = call double @square(double* %helper2)
%7 = load double, double* @g
store double %6, double* @g
%8 = load double, double* @g
%9 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %8)
ret i32 0 }

