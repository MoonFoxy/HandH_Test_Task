package classes

import interfaces.LimitedValue

class LimitedValueImpl(
    initValue: UInt, override val valueRange: UIntRange
) : LimitedValue {

    init {
        require(valueRange.step == 1) { "Шаг должен быть равен 1." }
        require(initValue in valueRange) { "Значение должно быть в диапазоне от ${valueRange.first} до ${valueRange.last}." }
    }

    private var _value: UInt = initValue

    override var value: UInt
        get() = _value
        set(newValue) {
            require(newValue in valueRange) { "Значение должно быть в диапазоне от ${valueRange.first} до ${valueRange.last}." }
            _value = newValue
        }
}