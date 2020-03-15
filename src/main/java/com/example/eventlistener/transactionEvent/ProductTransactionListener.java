package com.example.eventlistener.transactionEvent;

import com.example.eventlistener.entityEvent.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class ProductTransactionListener {

    /*
        phase : COMMIT 이후에 실행할 것인지 이전에 실행할 것인지 실행 순서를 제어할 수 있다
        fallbackExecution : 트랜잭션과는 무관하게 항상 실행할 것인지
        condition : 이벤트 리스너가 작동하는 조건 설정
     */

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT, fallbackExecution = true, condition = "#product.content == '인서트 테스트'")
    void listenBeforeEvent(Product product) {
        log.info("TransactionalEventListener 이벤트 발생 : {}", "BEFORE_COMMIT");
        log.info("이벤트 : {}", product);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT, fallbackExecution = true)
    void listenAfterEvent(Product product) {
        log.info("TransactionalEventListener 이벤트 발생 : {}", "AFTER_COMMIT");
        log.info("이벤트 : {}", product);
    }
}
