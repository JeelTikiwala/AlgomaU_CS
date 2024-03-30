COMMENT !
	Author: Jeel Tikiwala
	Student Number: 239659420
	Assignment 3, Q3
	Any work in this file is my own.
!
INCLUDE C:\Irvine\Irvine32.inc

.data
	array dword 13,14,20,27,30
.code
main proc
	mov esi, 0
	mov edi, sizeof array				;considering the size of the array
	sub edi, type array					;adjusting edi to point last element in the array
	mov ecx, lengthof array				;length of the array
	loop1:
		mov eax, array[esi]				;move curr element from first into EAX
		xchg eax, array[edi]
		mov array[esi],eax

		add esi, type array				
		sub edi, type array				

		sub ecx, 1						;sub the ecx by 1 as we have to run the loop only half time
		cmp ecx,0						;setting the compare instruction for the odd numbers
		je outside
		loop loop1

	outside:				;label to exit the loop

	;print the reverse array
	mov ecx, lengthof array
	mov esi, 0

	loop2:								
		mov eax, array[esi]					;moving the value
		call writeInt						;printing the output
		call crlf							;printing new line
		
		add esi, type array
		loop loop2							;continue lloping until all the elements are printed
	exit									;exit the program
main endp
end main