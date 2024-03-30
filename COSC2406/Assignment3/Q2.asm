COMMENT !
	Author: Jeel Tikiwala
	Student Number: 239659420
	Assignment 3, Q2
	Any work in this file is my own.
!
INCLUDE C:\Irvine\Irvine32.inc

.data
	
.code
main proc
		mov ecx, 20			;setting the loop counter to 20 for printing the first 20 numbers
		mov edx, 1			;Initialize  edx with 1, Fib(1) in the sequence
		mov ebx, 1			;Initialize edx with 0, Fib(0) in the sequqence
	
	loop1:
		call writeDec			;prints current fibonacci value in edx
		call crlf				;prints new line

		mov eax, edx			;add value of (Fib(n-2)) to eax
		add eax, ebx			;add value of (Fib(n-1)) eax, results = Fib(n)
		mov edx, ebx			;move Fib(n-1) the Fib(n-2)
		mov ebx, eax			;move Fib(n-1) to Fib(n)
		loop loop1				;repeat the loop until the ecx not equals 0
	exit						;exit the program
main endp
end main