package Registers;

public enum RegisterARM {
  r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12,
  SP, LR, PC, CPSR, SPSR, NULL_REG;
}

/**
 * R0 - R12 - general purpose register
 * R13 / SP - which holds the Stack Pointer
 * R14 / LR - the Link Register which holds the caller's return address
 * R15/ PC - which holds the Program Counter
 * CPSR - which is the Current Program Status Register. This holds flags which are results of arithmetic
 * and logical operations.
 * SPSR - which is Saved Program Status Register. This holds code flags.
 */
