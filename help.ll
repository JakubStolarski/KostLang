declare i32 @printf(i8*, ...)
declare i8* @strcpy(i8*, i8*)
declare i8* @strcat(i8*, i8*)
declare i32 @__isoc99_scanf(i8*, ...)
declare void @llvm.memcpy.p0i8.p0i8.i64(i8* noalias nocapture writeonly, i8* noalias nocapture readonly, i64, i1 immarg)
@strps = constant [4 x i8] c"%s\0A\00"
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [5 x i8] c"%10s\00"
define i32 @hello(i32* %b, i32* %d) nounwind {
%1 = load i32, i32* %b
%2 = load i32, i32* %d
%3 = add i32 %1, %2
%result = alloca i32
store i32 %3, i32* %result
%4 = load i32, i32* %result
ret i32 %4 }
@a = global i32 0
define i32 @main() nounwind{
%1 = add i32 3, 1
%a = alloca i32
store i32 5, i32* %a
%2 = call i32 @hello(i32* %a, i32* %a)
store i32 %2, i32* @a
%3 = load i32, i32* @a
%4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %3)
ret i32 0 }



a = 3 + 1

int hello(b:real, d:real)
b = b + 1.3
d = d + 0.5
result = b+d
print result
print a
a = 8
return 0 endf
ba = 3.2
da = 4.5
hello(ba, da)
sq = square(da)
