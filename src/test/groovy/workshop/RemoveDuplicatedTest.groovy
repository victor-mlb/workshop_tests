package workshop

import org.mockito.Mockito
import spock.lang.Specification
import workshop.api.IntegerApi

class RemoveDuplicatedTest extends Specification {
    def "should remove duplicate from list"() {
        when:
            List<Integer> result = RemoveDuplicated.call(input)
        then:
            result == expectedOutput
        where:
            input           || expectedOutput
            [1,1,2,2,3,3]   || [1, 2, 3]
            [1, 2]          || [1, 2]
            []              || []
            null            || []
    }

    def "should remove duplicate from array"() {
        when:
            List<Integer> result = RemoveDuplicated.call(input as Integer[])
        then:
            result == expectedOutput
        where:
            input           || expectedOutput
            [1,1,2,2,3,3]   || [1, 2, 3]
            [1, 2]          || [1, 2]
            []              || []
            null            || []
    }

    def "should remove duplicate from integers api"() {
        given:
            IntegerApi integerApi = Mockito.mock(IntegerApi.class)
            Mockito.when(integerApi.fetchIntegers()).thenReturn(input as Integer[]);
        when:
            List<Integer> result = RemoveDuplicated.call(integerApi)
        then:
            result == expectedOutput
        where:
            input           || expectedOutput
            [1,1,2,2,3,3]   || [1, 2, 3]
            [1, 2]          || [1, 2]
            []              || []
            null            || []
    }
}
