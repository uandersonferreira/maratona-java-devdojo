public class IncrementDecrementExample03 {
    public static void main(String[] args) {
        //Vamos ajustar o exemplo para usar operadores de 
        //decremento (`--x` e `x--`) e fornecer o resumo do processo:

        int x = 0;
        int i = 5;
        ++x;  // Incremento para fazer x ser diferente de zero inicialmente
        x = i--;  // i é decrementado depois de sua atribuição a x
        
        if (x-- >= 1) {
            x -= --x;  // Usando decrementos prefixado e posfixado dentro do if
        }
        System.out.println(i);
        System.out.println(x);
        
        // ### Resumo do processo
        
        // 1. `x = 0`
        // 2. `i = 5`
        // 3. `++x` → `x` se torna `1` (incremento prefixado)
        // 4. `x = i--` → `x` recebe o valor de `i` (que é `5`), depois `i` se torna `4` (decremento posfixado)
        // 5. `if (x-- >= 1)` → `x` é `5` durante a comparação, então `5 >= 1` é `true`. Depois, `x` se torna `4` (decremento posfixado)
        // 6. Como a condição do `if` é `true`, `x -= --x` é executado:
        //    - `--x` → `x` se torna `3` (decremento prefixado)
        //    - `x -= 3` → `x` se torna `4 - 3 = 1`
        // 7. `System.out.println(i)` imprime `4`
        // 8. `System.out.println(x)` imprime `1`
        
        // Portanto, a saída do programa é:
        // ```
        // 4
        // 1
        // ```

    }//main
}//class
