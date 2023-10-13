// src/test/resources/contracts/jsonContract.groovy
org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/json'
    }
    response {
        status 200
        body([
                message: "Hello JSON"
        ])
        headers {
            contentType(applicationJson())
        }
    }
}


