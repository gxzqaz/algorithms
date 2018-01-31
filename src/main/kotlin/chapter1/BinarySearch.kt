package chapter1


/**
 * @author yanghuan
 *
 */

fun binarySearch(key: Int, array: Array<Int>): Int {
    var low = 0
    var high = array.size - 1
    while (low <= high) {
        val mid = low + (high - low) / 2
        when {
            array[mid] < key -> low = mid + 1
            array[mid] >= key -> high = mid - 1
        }
    }
    if (array.size <= low || array[low] != key) {
        return -1
    }
    return low
}

fun binarySearchRecur(key: Int, array: Array<Int>, low: Int, high: Int): Int {
    if (low > high) {
        return low
    }
    val mid = low + (high - low) / 2
    if (array[mid] >= key) {
        return binarySearchRecur(key, array, low, mid - 1)
    } else {
        return binarySearchRecur(key, array, mid + 1, high)
    }
}

fun main(args: Array<String>) {
    var list = arrayOf(0, 1, 3, 3, 4, 5, 6)
    println(binarySearch(6, list))
    println(binarySearchRecur(6, list, 0, list.size - 1))
}