COMMENT !
	Author: Jeel Tikiwala
	Student Number: 239659420
	Lab8, Q3
	Any work in this file is my own.
!
INCLUDE C:\Irvine\Irvine32.inc

.data
	array BYTE 101 DUP(0)
	prompt BYTE "Enter the String: ",0
	answer BYTE "The encrypted string is: ",0
	answer2 BYTE "The decrypted string is: ",0
.code
main proc							;main procedure
	mov edx, offset prompt
	call WriteString				;display the message
	mov edx, offset array					
	mov ecx, lengthof array				
	call ReadString					;reading the string

	mov edx, offset answer
	call WriteString	
	call encrypt				;call the method to encrypt the given string
	mov edx, offset array
	call WriteString			;print the encrypted string
	call crlf 

	mov edx, offset answer2
	call WriteString			;display the message
	call decrypt				;call the method to decrypt the sring
	mov edx, offset array
	call WriteString			;call the decyptrd string
	call crlf					;print the encrypted string
	exit
main endp

encrypt proc
	mov esi, 0
	mov ecx, lengthof array
	loop1:
		mov al, array[esi]					;moving the array value to the al using the indexed array
		ror al, 1			;rotate the caharcter by 1
		mov array[esi], al				;now again store the value
		add esi, type array				;mov to next index
		loop loop1
	ret
encrypt endp

decrypt proc
	mov esi, 0
	mov ecx, lengthof array
	loop2:
		mov al, array[esi]			;moving the array value to the al using the indexed array
		rol al, 1			;rotate the caharcter by 1
		mov array[esi], al			;now again store the value
		add esi, type array			;mov to next index
		loop loop2
	ret
decrypt endp
end main