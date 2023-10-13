package contracts
// src/test/resources/contracts/xmlContract.groovy
org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/xml'
    }
    response {
        status 200
        body("""
            <message>
                <message>Hello XML</message>
            </message>
        """)
        headers {
            contentType(applicationXml())
        }
    }
}