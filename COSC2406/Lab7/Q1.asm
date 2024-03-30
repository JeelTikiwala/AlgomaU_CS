COMMENT !
	Author: Jeel Tikiwala
	Student Number: 239659420
	Lab7, Q1
	Any work in this file is my own.
!
INCLUDE C:\Irvine\Irvine32.inc

.data

	array DWORD 20 DUP(0)										; defining arrays of DWORDs
	ptext BYTE " Positive Numbers in the Array are :",0			;	message for positive numbers
	ntext BYTE " Negative Numbers in the Array are :",0			;	message for negative numbers
	mtext BYTE " Randomly Generated Numbers in the Array are :",0


.code

randomnum PROC		;  procedure to generate random numbers

	PUSHFD			; preserve flag registers
	PUSH EBX		; prserve EBX registers
	
	MOV EAX, 1000   ; upper limit of range
	MOV EBX, -1000  ; lower limit of range
	SUB EAX, EBX	;calculate range span

	INC EAX				; high - low + 1
	CALL randomrange	; Math.random()*(high - low + 1)
	ADD EAX, EBX		; low + Math.random()*(high - low + 1)

	POP EBX		; preserve EBX regsiters
	POPFD		; preserve registers
	
	RET
randomnum ENDP

positivedisplay PROC		 ; procedure to display positive numbers
	
	PUSHFD
	PUSHAD					;preserve all purpose flags

	MOV EDX, OFFSET ptext
	CALL WriteString

	MOV ECX, 20				; loop 20 times
	MOV ESI, OFFSET array 

DisplayLoop:							; Initialize Loop

	MOV EAX, [ESI]					; Indexing array	

	CMP EAX, 0
	JL elsecode						;skip to if-elseif no is -ve

	MOV AL, ' ' 
	CALL WriteChar
	CALL WriteInt						; Displaying array elements

elsecode:		; else part to jump
	ADD ESI,4		;move to next element in the array

	Loop DisplayLoop					; Loop end

	POPAD
	POPFD

	RET
positivedisplay ENDP ;positive procedure ends

negativedisplay PROC ; procedure to display negative numbers
	
	PUSHFD
	PUSHAD

	MOV EDX, OFFSET ntext
	CALL WriteString

	MOV ECX, 20			;loop 20 times
	MOV ESI, OFFSET array 

DisplayLoop:							; Initialize Loop

	MOV EAX, [ESI]					; Indexing array	

	CMP EAX, 0
	JG elsecode

	MOV AL, ' ' 
	CALL WriteChar
	CALL WriteInt						; Displaying array elements

elsecode:
	ADD ESI,4

	Loop DisplayLoop					; Loop end

	POPAD
	POPFD

	RET
negativedisplay ENDP ;negative procedure ends


main PROC
	
	CALL randomize		; randomize call
	
	MOV ECX, 20
	MOV ESI, 0

InputLoop:								; Initialize Loop

	CALL randomnum			
	MOV array[ESI*4], EAX					; Storing Input in array
	INC ESI							; Increment the array index

	Loop InputLoop
	
	MOV EDX, OFFSET mtext
	CALL WriteString

	MOV ECX, 20						; setting loop counter to 20
	MOV ESI, 0							; setting loop iteraator back to 0

DisplayLoopm:							

	MOV EAX, array[ESI*4]					
	MOV AL, ' ' 
	CALL WriteChar
	CALL WriteInt						
	INC ESI													

	Loop DisplayLoopm					; Loop ends

	CALL CRLF 
	CALL CRLF

	CALL positivedisplay
	CALL CRLF					; Calling Procedures
	CALL negativedisplay

	CALL CRLF
	EXIT
main ENDP
end main