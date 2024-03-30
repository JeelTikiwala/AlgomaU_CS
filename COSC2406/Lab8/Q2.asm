COMMENT !
	Author: Jeel Tikiwala
	Student Number: 239659420
	Lab8, Q2
	Any work in this file is my own.
!
INCLUDE C:\Irvine\Irvine32.inc

.data
	prompt BYTE "Enter number: ",0		;prompt number from the user
.code
main proc
	mov edx, offset prompt
	call WriteString				;prompt message to the user
	call ReadDec					;read decimal from the user
	call multiplication				;multiplication method
	call WriteDec					;printing the output
	call crlf			

	mov edx, offset prompt
	call WriteString			;prompt message to the user
	call ReadDec				;read decimal from the user
	call division				;division method
	call WriteDec				;printing the output
	call crlf
	exit						;exit the program
main endp

multiplication proc
	shl eax,1				;shl will multiply the number by 2
	ret
multiplication endp

division proc
	shr eax,1				;shr will divide the number by 2
	ret
division endp
end main