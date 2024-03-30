COMMENT !
	Author: Jeel Tikiwala
	Student Number: 239659420
	Assignment, Q1
	Any work in this file is my own.
!
Include C:\Irvine\Irvine32.inc

.data
	key BYTE "ABXmv#7",0
	text BYTE "This is a Plaintext message",0
.code
main proc
	mov edx, offset text
	call WriteString			;printing the output
	call crlf					;printing the new line
		
	call encrypt_decrypt		;calling the method to encrypt the text
	mov edx, offset text
	call WriteString			;printing the string
	call crlf					;printing the new line
	exit								;exit from the program
main endp


encrypt_decrypt proc
	pushad				; Push all general-purpose registers
	pushfd				; Push register


	mov ecx, lengthof text - 1				;storing the length of the text
	mov esi, 0							;key index
	mov edi, 0							;text index
	loop1:
		cmp key[esi], 0				;if the null termintaion reched then set the esi again
		jne pass
		mov esi, 0					;reset key index to 0

		pass:
		mov al, key[esi]				;moving the key to perform the xor operation
		xor text[edi],al				;xoring the text
		inc esi							;moving to next index
		inc edi							;moving to next index
		loop loop1
	popfd				
	popad				
	ret
encrypt_decrypt endp
end main