COMMENT !
	Author: Jeel Tikiwala
	Student Number: 239659420
	Lab6, Q1
	Any work in this file is my own.
!
Include C:\Irvine\Irvine32.inc

.data
    msg BYTE "Hello, Jeel here. My favourite food is Pasta.",0   ; Define the message to be displayed

.code
main proc
    mov edx, offset msg  ; Load the address of the message into EDX
    call ShowAllColors   ; Call the procedure to display the message in different colors
    exit                 ; Exit the program
main endp

; This Procedure prints the message 256 times, each in a different text color.
ShowAllColors proc
    pushad               ; Preserve the values of all general-purpose registers
    pushfd               ; Preserve the flags

    mov ecx, 256         ; ECX to 256 for the loop counter
    mov eax, 0           ; EAX to 0, will be used for text color setting

    loop1:
        call SetTextColor            ; STEP-(A) = Set the text color according to EAX value
        call WriteString             ; STEP-(b) = Print the Message
        call crlf                    ; Move to the next line

        inc eax                      ; STEP-(C) = Increment EAX to change the color in the next iteration
        xchg eax, ebx                ; STEP-(D) = Exchange EAX with EBX to temporarily store the color value
        mov eax, 0                   ; Reset EAX to 0 to set text color to black temporarily
        call SetTextColor            ; STEP-(E) = Apply the black text color setting
        mov eax, 50                  
        call Delay                   ; STEP-(F) = Delay
        xchg eax, ebx                ; STEP-(G) =  Exchange EAX with EBX again
        loop loop1                   ; loop

    mov eax, 07h                     ; Set text color back to grey on black for clean exit
    call SetTextColor                ; Apply the final text color setting

    popfd               ; Restore the flags
    popad               ; Restore the preserved general-purpose registers
    ret
ShowAllColors endp
end main
