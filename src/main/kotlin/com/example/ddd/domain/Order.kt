import com.example.ddd.domain.Money
import com.example.ddd.domain.ShippingInfo
import java.lang.IllegalStateException

/**
 * 주문 정보를 나타내는 객체

 * @property orderLines 주문 목록을 저장하는 리스트
 * @property shippingInfo 배송지 정보
 * @throws IllegalArgumentException 주문 목록이 비어있을 시
 *
*/
class Order(
    private val orderLines: List<Order>,
    private var shippingInfo: ShippingInfo
){
    init {
        verifyAtLeastOneOrMoreOrderLine()
    }
    private var state: OrderState = OrderState.PAYMENT_WAITING
    enum class OrderState{
        PAYMENT_WAITING, PREPARING, SHIPPED, DELIVERING, DELIVERY_COMPLETED, CANCELED
    }

    /**
     * 배송지 변경
     * @throws IllegalStateException 이미 주문이 배송을 시작하였을 시
     */
    fun changeShippingInfo(newInfo: ShippingInfo){
        verifyNotYetShipped()
        shippingInfo = newInfo
    }

    fun changeShipped(){

    }
    fun cancel(){
        verifyNotYetShipped()
        state = OrderState.CANCELED
    }
    fun completePayment(){}

    private val totalAmounts: Money = orderLines.map { it.totalAmounts }.reduce { acc, money ->  acc + money}
    private fun verifyNotYetShipped(){
        when(state){
            OrderState.PREPARING, OrderState.PAYMENT_WAITING -> return
            else -> throw IllegalStateException("already shipped")
        }
    }
    private fun verifyAtLeastOneOrMoreOrderLine() {
        if (orderLines.isEmpty())
            throw IllegalArgumentException("no OrderLine")
    }
}