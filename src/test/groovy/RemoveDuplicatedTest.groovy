import spock.lang.Specification

class RemoveDuplicatedTest extends Specification{

    def "shoud removeDuplicate"() {
        given:
            RemoveDuplicated removeDuplicated = new RemoveDuplicated()
        when:
            List<Integer> result = removeDuplicated.removeDuplicate()
        then:
            result == expectedResult
        where:
            expectedResult | _
            [1, 2, 3]      | _
    }
}
