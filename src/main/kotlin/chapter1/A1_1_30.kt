package chapter1;

/**
 * @author yanghuan
 */

/**
 * 质数
 */
fun isPrime(a: Int, b: Int): Boolean {
    if (a == 1 || b == 1) {
        return true
    }
    return gcb(a, b) == 1
}

fun gcb(a: Int, b: Int): Int {
    if (b == 0) {
        return a
    }
    var temp = a % b
    return gcb(b, temp)
}

fun main(args: Array<String>) {
    generateArray(5)
}

fun generateArray(n: Int) {
    if (n < 1) {
        return
    }
    val array: Array<Array<Boolean?>> = Array(n, { arrayOfNulls<Boolean>(n) })
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (array[j][i] != null) {
                array[i][j] = array[j][i]
            } else {
                // 因为下标是0开始，所以要 +1 数据才对
                array[i][j] = isPrime(i + 1, j + 1)
            }
        }
    }
    for (arr in array) {
        for (a in arr) {
            print(a.toString() + " ")
        }
        println()
    }
}
