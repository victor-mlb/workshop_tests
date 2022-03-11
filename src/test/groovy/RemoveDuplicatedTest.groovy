import api.NumbersApi
import org.mockito.Mockito
import spock.lang.Specification

class RemoveDuplicatedTest extends Specification{
    def "should return list ordened"() {

            given:
            RemoveDuplicated rd = new RemoveDuplicated();
            when:
            def result = rd.distinctListOrder(test)
            then:
            result == expected
            where:
            test | expected
            [6, 9, 15, -2, 92, 11] as Integer[] | [-2, 6, 9,11, 15, 92]
            null | [] as Integer[]
            [] as Integer[] | [] as Integer[]

    }
}
