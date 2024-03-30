COMMENT !
	Author: Jeel Tikiwala
	Student Number: 239659420
	Assignment 3, Q1
	Any work in this file is my own.
!

;This program will use addition and subtraction to solve a formula: (2P + R) - (Q - S) - 3T 

INCLUDE C:\Irvine\Irvine32.inc


.data
	P word 7
	R word 14
	Q word 3
	S word 1
	T word 4
	prompt byte "The output for the forumla (2P + R) - (Q - S) - 3T  is: ",0
.code
main proc
	mov eax, 0			;clearing the eax register so that we can print the 16 bit value

	;calculating (2P+R)
	mov ax, P			;moving P into ax register
	add ax, P			;adding P to the ax register
	add ax, R			;adding R to the ax register

	;calculating Q-S
	mov bx, Q			;moving Q to bx register
	sub bx, S			;subtracting s from bx register

	;calculating 3T
	mov cx, 3			;moving 3 to cx register
	add cx, 3			;adding 3 to cx register
	add cx, 3			;adding 3 to cx register

	sub ax, bx			;subtracting (2P+R)-(Q-S)
	sub ax, cx			;finally : (2P + R) - (Q - S) - 3T

	mov edx, offset prompt				;printing the mesage and the answer
	call writeString					;calling writeString to get output
	call writeInt						;calling writeInt for result
main endp
end main
