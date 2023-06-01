declare i32 @printf(i8*, ...)
declare i8* @strcpy(i8*, i8*)
declare i8* @strcat(i8*, i8*)
declare i32 @__isoc99_scanf(i8*, ...)
declare void @llvm.memcpy.p0i8.p0i8.i64(i8* noalias nocapture writeonly, i8* noalias nocapture readonly, i64, i1 immarg)
@strps = constant [4 x i8] c"%s\0A\00"
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [5 x i8] c"%10s\00"
@str1 = constant [6 x i8] c"Hello\00"
@str2 = constant [8 x i8] c" World!\00"
define i32 @main() nounwind{
%1 = add i32 1, 2
%a = alloca i32
store i32 %1, i32* %a
%2 = fmul double 2.1, 3.2
%b = alloca double
store double %2, double* %b
%3 = fsub double 4.5, 1.5
%c = alloca double
store double %3, double* %c
%4 = sdiv i32 8, 6
%d = alloca i32
store i32 %4, i32* %d
%str1 = alloca [6 x i8]
%5 = bitcast [6 x i8]* %str1 to i8*
call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 1 %5, i8* align 1 getelementptr inbounds ([6 x i8], [6 x i8]* @str1, i32 0, i32 0), i64 6, i1 false)
%ptrstr1 = alloca i8*
%6 = getelementptr inbounds [6 x i8], [6 x i8]* %str1, i64 0, i64 0
store i8* %6, i8** %ptrstr1
%e = alloca i8*
store i8* %6, i8** %e
%str2 = alloca [8 x i8]
%7 = bitcast [8 x i8]* %str2 to i8*
call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 1 %7, i8* align 1 getelementptr inbounds ([8 x i8], [8 x i8]* @str2, i32 0, i32 0), i64 8, i1 false)
%ptrstr2 = alloca i8*
%8 = getelementptr inbounds [8 x i8], [8 x i8]* %str2, i64 0, i64 0
store i8* %8, i8** %ptrstr2
%f = alloca i8*
store i8* %8, i8** %f
%str3 = alloca [13 x i8]
%ptrstr3 = alloca i8*
%9 = getelementptr inbounds [13 x i8], [13 x i8]* %str3, i64 0, i64 0
store i8* %9, i8** %ptrstr3
%10 = load i8*, i8** %ptrstr1
%11 = load i8*, i8** %ptrstr2
%12 = load i8*, i8** %ptrstr3
%13 = call i8* @strcpy(i8* %12, i8* %10)
%14 = call i8* @strcat(i8* %13, i8* %11)
%ef = alloca i8*
store i8* %14, i8** %ef
%g = alloca i32
store i32 12, i32* %g
%h = alloca i8
store i8 1, i8* %h
%i = alloca i8
store i8 1, i8* %i
%j = alloca i8
store i8 1, i8* %j
%k = alloca i8
store i8 0, i8* %k
%15 = load i32, i32* %a
%16 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %15)
%17 = load double, double* %b
%18 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %17)
%19 = load double, double* %c
%20 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %19)
%21 = load i32, i32* %d
%22 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %21)
%23 = load i8*, i8** %e
%24 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strps, i32 0, i32 0), i8* %23)
%25 = load i8*, i8** %f
%26 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strps, i32 0, i32 0), i8* %25)
%27 = load i8*, i8** %ef
%28 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strps, i32 0, i32 0), i8* %27)
%29 = load i32, i32* %g
%30 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %29)
%31 = load i8, i8* %h
%32 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i8 %31)
%33 = load i8, i8* %i
%34 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i8 %33)
%35 = load i8, i8* %j
%36 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i8 %35)
%37 = load i8, i8* %k
%38 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i8 %37)
ret i32 0 }

