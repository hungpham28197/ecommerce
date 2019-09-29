//package com.hungpham.ecommerce;
//
//import com.hungpham.ecommerce.event.*;
//import com.hungpham.ecommerce.model.entity.Product;
//import com.hungpham.ecommerce.repository.ProductRepository;
//import com.lmax.disruptor.RingBuffer;
//import com.lmax.disruptor.dsl.Disruptor;
//import com.lmax.disruptor.util.DaemonThreadFactory;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class EcommerceApplicationTests {
//    @Autowired
//    CommandEventProducer commandEventProducer;
//
//    @Autowired
//    ProductRepository productRepository;
//
//    @Test
//    public void contextLoads() {
//        System.out.println("done!!!!");
//    }
//
//    @Test
//    public void testHandlerCommand() {
////        // The factory for the event
////        CommandEventFactory factory = new CommandEventFactory();
////        // Specify the size of the ring buffer, must be power of 2.
////        int bufferSize = 1024;
////        // Construct the Disruptor
////        Disruptor<CommandEvent> disruptor = new Disruptor<>(factory, bufferSize, DaemonThreadFactory.INSTANCE);
////        // Connect the handler
////        disruptor.handleEventsWith(new EventCommandHandler<>(productRepository));
////
////        // Start the Disruptor, starts all threads running
////        disruptor.start();
////
////        // Get the ring buffer from the Disruptor to be used for publishing.
////        RingBuffer<CommandEvent> ringBuffer = disruptor.getRingBuffer();
////        CommandEventProducer producer = new CommandEventProducer(ringBuffer);
//
//        Command<Product, ProductRepository> command = new Command<>();
//        Product product = new Product();
//        product.setName("test-product");
//        command.setBody(product);
//        command.setType(1);
//        command.setPersistent(productRepository);
//
//        commandEventProducer.onData(command);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
