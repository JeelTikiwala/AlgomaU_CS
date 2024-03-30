COMMENT !
	Author: Jeel Tikiwala
	Student Number: 239659420
	Lab6, Q2
	Any work in this file is my own.
!
Include C:\Irvine\Irvine32.inc

.data
	highRange BYTE "Enter High Range: ",0		;prompt for entering high range
	lowRange BYTE "Enter Low Range: ",0			;prompt for entering low range
	result BYTE "The number betwen the given the given High Range and Low Range is: ",0					;display the result
	hval SDWORD ?								;to store high range input
	lval SDWORD ?								;to store low range input
.code
main proc
	;prompt to store high range value from the user
	mov edx, offset highRange
	call writeString
	call readInt
	mov hval, eax

	;Prompt and store the low range value from the user
	mov edx, offset lowRange
	call writeString
	call readInt
	mov lval, eax

	;display the message
	mov edx, offset result
	call writeString
	call Randomness
	exit								;exit from the program
main endp

Randomness proc
	pushad						;preserving the state of all purpose registers value
	pushfd						;preserve the flag registers
	
	mov eax, hval				;moving the hval in the eax(load high value in EAX)
	sub eax, lval				;now subtracting the hval by lval to produce the result appro.(lowvalue - highvallue to get the range)
	call Randomize				;calling the method
	call RandomRange			;calling the method to produce the output(hval -vval range)

	add eax, lval				;adding the lval in the eax

	call WriteInt				;printing the random number output

	popfd						;restore the flag registers
	popad						;restore the state of all general purpose registers

	ret
Randomness endp
end main