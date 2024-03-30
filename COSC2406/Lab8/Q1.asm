COMMENT !
	Author: Jeel Tikiwala
	Student Number: 239659420
	Lab8, Q1
	Any work in this file is my own.
!
INCLUDE C:\Irvine\Irvine32.inc


.data
    multiply BYTE "The multiplication of the first two numbers is: ",0
    divide BYTE "The division of the second two numbers is: ",0
    reminder BYTE "The remainder of the third two numbers is: ",0
    prompt BYTE "Please enter two unsigned numbers: ",0

.code
main proc
    ; First pair
    mov edx, offset prompt
    call WriteString
    call ReadDec
    mov ebx, eax                ; Store the first integer
    call ReadDec                ; EAX now holds the second integer
                                
    mul ebx                     ; Multiply EAX by EBX
    mov edx, offset multiply
    call WriteString
    call WriteDec               ; Display multiplication result
    call Crlf                   

    ; Second pair
    mov edx, offset prompt
    call WriteString
    call ReadDec
    mov ebx, eax                ; Store the first integer
    call ReadDec                ; EAX now holds the second integer
    xor edx, edx                ; Clear EDX before division
    div ebx                     ; Divide EAX by EBX
    mov edx, offset divide
    call WriteString
    call WriteDec               ; Display division result
    call Crlf                   

    ; Third pair
    mov edx, offset prompt
    call WriteString
    call ReadDec
    mov ebx, eax                ; Store the first integer
    call ReadDec                ; EAX now holds the second integer
    xor edx, edx                ; Clear EDX before division for a clean start
    div ebx                     ; Divide EAX by EBX, remainder will be in EDX
    mov edx, offset reminder
    call WriteString
    mov eax, edx                ; Move remainder to EAX for displaying
    call WriteDec               ; Display remainder
    call Crlf                   

    exit
main endp
end main
