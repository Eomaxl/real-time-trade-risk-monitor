import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "broker-client", url = "${broker.api.url}")
public interface BrokerClient {

    @PostMapping("/orders")
    void submitOrder(@RequestBody BrokerOrderRequest order);
}