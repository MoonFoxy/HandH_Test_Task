package classes

import interfaces.LimitedValue

/**
 * LimitedValueImpl class represents a value with a limited range.
 *
 * @param initValue the initial value of the LimitedValue
 * @param valueRange the range of values that the LimitedValue can have
 */
class LimitedValueImpl(
    initValue: UInt, override val valueRange: UIntRange
) : LimitedValue {
    init {
        require(valueRange.step == 1) { "The step should be 1." }
        require(initValue in valueRange) { "The value must be in the range from ${valueRange.first} to ${valueRange.last}." }
    }

    private var _value: UInt = initValue

    override var value: UInt
        get() = _value
        set(newValue) {
            require(newValue in valueRange) { "The value must be in the range from ${valueRange.first} to ${valueRange.last}." }
            _value = newValue
        }
}