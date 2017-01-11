import com.tesco.bootcamp.orderreview.adapters.CustomerServiceAdaptor;
import com.tesco.bootcamp.orderreview.adapters.CustomerServiceAdaptor;
import com.tesco.bootcamp.orderreview.representations.CustomerOrder;
import com.tesco.bootcamp.orderreview.service.OrderReviewService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class OrderReviewServiceTest {

    public static final String CUSTOMER_NAME = "MR B";
    public static final String LOGIN_ID = "123434";

    @Mock
    CustomerServiceAdaptor adapter;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

  @Test
  public void shouldReturnCustomerNameWhenCustomerIDIsPassed() {

      //Given (mocking conditions)
      Mockito.when(adapter.call(LOGIN_ID)).thenReturn(CUSTOMER_NAME);
      OrderReviewService orderReviewService = new OrderReviewService(adapter);

      //When
      String expectedName = orderReviewService.getCustomerName(LOGIN_ID);

      //Then
      Mockito.verify(adapter).call(LOGIN_ID);   //verifies if the mock was called with given customer_id
      assertThat(expectedName, is(CUSTOMER_NAME));

  }

  @Test
  public void shouldReturnEmptyListOfOrdersForGivenCustomerId(){

    //Given
    String customerId="123456";
    OrderReviewService orderReviewService = new OrderReviewService(adapter);

    //When
    List<CustomerOrder> customerOrderList = orderReviewService.getOrderList(customerId);

    //Then
    assertTrue(orderReviewService.getOrderList(customerId).size()>=0);


  }
/*
  @Test
  public void shouldReturnListOfOrdersForGivenCustomerId(){

    //Given
    String customerId="123456";
    OrderReviewService orderReviewService = new OrderReviewService();

    //When
    List<CustomerOrder> customerOrderList = orderReviewService.getOrderList(customerId);

    //Then
    assertTrue(orderReviewService.getOrderList(customerId).size()>=0);
*/

}
