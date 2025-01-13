public class IncrementDecrementExample02 {
    public static void main(String[] args) {
    
    //Vamos analisar o novo código fornecido, que
    //envolve o uso de `++x`, `i++`, `x++`, e `
    //++x`, e fornecer o resumo do processo:

int x = 0;
int i = 5;
++x;
x = i++;

if (x++ >= 1) {
    x += ++x;
}
System.out.println(i);
System.out.println(x);


// ### Resumo do processo

// 1. `x = 0`
// 2. `i = 5`
// 3. `++x` → `x` se torna `1` (incremento prefixado)
// 4. `x = i++` → `x` recebe o valor de `i` (que é `5`), depois `i` se torna `6` (incremento posfixado)
// 5. `if (x++ >= 1)` → `x` é `5` durante a comparação, então `5 >= 1` é `true`. Depois, `x` se torna `6` (incremento posfixado)
// 6. Como a condição do `if` é `true`, `x += ++x` é executado:
//    - `++x` → `x` se torna `7` (incremento prefixado)
//    - `x += 7` → `x` se torna `6 + 7 = 13`
// 7. `System.out.println(i)` imprime `6`
// 8. `System.out.println(x)` imprime `13`

// Portanto, a saída do programa é:
// ```
// 6
// 13
// ```

    }//main
}//class
