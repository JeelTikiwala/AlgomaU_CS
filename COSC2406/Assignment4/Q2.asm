COMMENT !
	Author: Jeel Tikiwala
	Student Number: 239659420
	Assignment, Q1
	Any work in this file is my own.
!
Include C:\Irvine\Irvine32.inc

.data
    num1Array DWORD 5,10,15,20,25            ; first numbers
    num2Array DWORD 50, 100, 300, 820, 750 ; second numbers

.code
main proc
    mov esi, 0                          ; index for array access
    mov ecx, lengthof num1Array         ; no of elements in the array
nextPair:
    mov eax, num1Array[esi]             ; load the first number of the current pair
    mov ebx, num2Array[esi]             ; load the second number of the current pair
    call gcd                            ; calculate GCD of the current pair
    add esi, type num1Array             
    loop nextPair
    exit                                ; exit the program
main endp

gcd proc
   
    cmp ebx, 0                          ; if currentDivisor is 0, then return
    jz done                             ; skip to the end if there's nothing to compute

gcdLoop:
    mov edx, 0                          ; clear the remainder
    div ebx                             ; div currentDividend/currentDivisor
    mov eax, ebx                        ; currentDividend becomes currentDivisor
    mov ebx, edx                        ; the remainder now becomes currentDivisor
    cmp ebx, 0                          ; check if the remainder is 0
    jne gcdLoop                         ; continue if not
done:
    call WriteInt                       ; print the GCD result
    call Crlf                           ; print a new line
    ret
gcd endp
end main
