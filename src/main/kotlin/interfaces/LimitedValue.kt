package interfaces

interface LimitedValue {
    val valueRange: UIntRange

    /**
     * value property represents the current value of the LimitedValue.
     */
    var value: UInt
}