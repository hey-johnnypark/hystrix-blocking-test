# hystrix-blocking-test
Simple test thatshowing that HystrixObservableCommands are using the same thread pool as the caller. Solution is using normal HystrixCommand.toObservable 
