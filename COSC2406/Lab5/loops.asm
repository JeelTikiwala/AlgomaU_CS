COMMENT !
	Author: Jeel Tikiwala
	Student Number: 239659420
	Lab5, Q1
	Any work in this file is my own.
!
INCLUDE C:\Irvine\Irvine32.inc

.DATA
array DWORD 10 DUP(?)                           ; Array to store the values(10 integers)
prompt BYTE "Enter 1o numbers: ", 0
resultMsg BYTE "[", 0                           
endMsg BYTE "]", 0                              
sumMsg BYTE "The sum of all values in the array is: ", 0

comma BYTE ", ", 0                  

.CODE
main PROC
    MOV ECX, 10                 ; The loop counter is set to 10
    MOV EBX, 0                  

loopLabel:
    MOV EDX, OFFSET prompt      ; Prompt to display
    CALL WriteString
    CALL ReadInt                ; Read the user input
    MOV array[EBX * 4], EAX     ; Store the input value in the array at index EBX
    ADD EBX, 1                  
    LOOP loopLabel              

    ; Display the collected values
    MOV EDX, OFFSET resultMsg
    CALL WriteString
    MOV ECX, 10                 
    MOV EBX, 0                  

loopDisplay:
    MOV EAX, array[EBX * 4]     
    CALL WriteDec               

    INC EBX                    
    CMP EBX, 10                
    JE LastValue                

    MOV EDX, OFFSET comma       
    CALL WriteString

    LOOP loopDisplay            

LastValue:
    ; Display closing bracket for the array elements
    MOV EDX, OFFSET endMsg
    CALL WriteString

    ; Calculate the sum of all values
    MOV ECX, 10                
    MOV EAX, 0                  

loopSum:
    ADD EAX, array[ECX * 4 - 4] 
    LOOP loopSum               

    CALL Crlf
    MOV EDX, OFFSET sumMsg     
    CALL WriteString
    CALL WriteDec              
    CALL Crlf

    EXIT
main ENDP
END main