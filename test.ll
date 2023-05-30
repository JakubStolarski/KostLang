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
@str1 = constant [3 x i8] c"yo\00"
@str2 = constant [4 x i8] c"abc\00"
@str3 = constant [4 x i8] c"def\00"
@str4 = constant [4 x i8] c"abc\00"
@str5 = constant [4 x i8] c"abc\00"
define i32 @main() nounwind{
%1 = fadd double 1.1, 1.2
%a = alloca double
store double %1, double* %a
%str1 = alloca [3 x i8]
%2 = bitcast [3 x i8]* %str1 to i8*
call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 1 %2, i8* align 1 getelementptr inbounds ([3 x i8], [3 x i8]* @str1, i32 0, i32 0), i64 3, i1 false)
%ptrstr1 = alloca i8*
%3 = getelementptr inbounds [3 x i8], [3 x i8]* %str1, i64 0, i64 0
store i8* %3, i8** %ptrstr1
%b = alloca i32
store i32 2, i32* %b
%c = alloca i8
store i8 1, i8* %c
%d = alloca i8
store i8 0, i8* %d
%e = alloca i8
store i8 0, i8* %e
%f = alloca i8
store i8 1, i8* %f
%str2 = alloca [4 x i8]
%4 = bitcast [4 x i8]* %str2 to i8*
call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 1 %4, i8* align 1 getelementptr inbounds ([4 x i8], [4 x i8]* @str2, i32 0, i32 0), i64 4, i1 false)
%ptrstr2 = alloca i8*
%5 = getelementptr inbounds [4 x i8], [4 x i8]* %str2, i64 0, i64 0
store i8* %5, i8** %ptrstr2
%ga = alloca i8*
store i8* %5, i8** %ga
%str3 = alloca [4 x i8]
%6 = bitcast [4 x i8]* %str3 to i8*
call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 1 %6, i8* align 1 getelementptr inbounds ([4 x i8], [4 x i8]* @str3, i32 0, i32 0), i64 4, i1 false)
%ptrstr3 = alloca i8*
%7 = getelementptr inbounds [4 x i8], [4 x i8]* %str3, i64 0, i64 0
store i8* %7, i8** %ptrstr3
%gb = alloca i8*
store i8* %7, i8** %gb
%str4 = alloca [4 x i8]
%8 = bitcast [4 x i8]* %str4 to i8*
call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 1 %8, i8* align 1 getelementptr inbounds ([4 x i8], [4 x i8]* @str4, i32 0, i32 0), i64 4, i1 false)
%ptrstr4 = alloca i8*
%9 = getelementptr inbounds [4 x i8], [4 x i8]* %str4, i64 0, i64 0
store i8* %9, i8** %ptrstr4
%str5 = alloca [4 x i8]
%10 = bitcast [4 x i8]* %str5 to i8*
call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 1 %10, i8* align 1 getelementptr inbounds ([4 x i8], [4 x i8]* @str5, i32 0, i32 0), i64 4, i1 false)
%ptrstr5 = alloca i8*
%11 = getelementptr inbounds [4 x i8], [4 x i8]* %str5, i64 0, i64 0
store i8* %11, i8** %ptrstr5
%str6 = alloca [7 x i8]
%ptrstr6 = alloca i8*
%12 = getelementptr inbounds [7 x i8], [7 x i8]* %str6, i64 0, i64 0
store i8* %12, i8** %ptrstr6
%13 = load i8*, i8** %ptrstr6
%14 = call i8* @strcpy(i8* ptrstr4)
%15 = call i8* @strcat(i8* ptrstr5)
%g = alloca i8*
store i8* %15, i8** %g
%16 = load double, double* %a
%17 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %16)
%18 = load i32, i32* %b
%19 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %18)
%20 = load i8, i8* %c
%21 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i8 %20)
%22 = load i8, i8* %d
%23 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i8 %22)
%24 = load i8, i8* %e
%25 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i8 %24)
%26 = load i8, i8* %f
%27 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i8 %26)
%28 = load i8*, i8** %g
%29 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strps, i32 0, i32 0), i8* %28)
ret i32 0 }

