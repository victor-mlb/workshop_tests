package workshop

import workshop.api.IntegerApi
import workshop.model.IntegerStatistics
import org.mockito.Mockito

import static spock.util.matcher.HamcrestMatchers.closeTo
import static spock.util.matcher.HamcrestSupport.that

import spock.lang.Specification

class ListHelperTest extends Specification {
    def "should extract statistics from a array of integers"() {
        when:
            IntegerStatistics statistic = ListHelper.getStatistics(input)
        then:
            that statistic.getAverage(), closeTo(average, 0.01)
            statistic.isSatisfyCondition() == satisfyCondition
            statistic.getSize() == size
            statistic.getMinimum() == minimum
            statistic.getMaximum() == maximum
        where:
            input                                | minimum | maximum | size | average   | satisfyCondition
            [6, 9, 15, -2, 92, 11] as Integer[]  | -2      | 92      | 6    | 21.833333 | true
            [1, 2, 3, 4, 5, 6] as Integer[]      | 1       | 6       | 6    | 3.5       | false
            [21] as Integer[]                    | 21      | 21      | 1    | 21        | false
            [] as Integer[]                      | 0       | 0       | 0    | 0         | false
            null as Integer[]                    | 0       | 0       | 0    | 0         | false
    }

    def "should extract statistics from a list of integers"() {
        when:
            IntegerStatistics statistic = ListHelper.getStatistics(input)
        then:
            that statistic.getAverage(), closeTo(average, 0.01)
            statistic.isSatisfyCondition() == satisfyCondition
            statistic.getSize() == size
            statistic.getMinimum() == minimum
            statistic.getMaximum() == maximum
        where:
            input                  | minimum | maximum | size | average   | satisfyCondition
            [6, 9, 15, -2, 92, 11] | -2      | 92      | 6    | 21.833333 | true
            [1, 2, 3, 4, 5, 6]     | 1       | 6       | 6    | 3.5       | false
            [21]                   | 21      | 21      | 1    | 21        | false
            []                     | 0       | 0       | 0    | 0         | false
            null                   | 0       | 0       | 0    | 0         | false
    }

    def "should extract statistics from integers api"() {
        given:
            IntegerApi integerApi = Mockito.mock(IntegerApi.class)
            Mockito.when(integerApi.fetchIntegers()).thenReturn(input as Integer[]);
        when:
            IntegerStatistics statistic = ListHelper.getStatistics(integerApi)
        then:
            that statistic.getAverage(), closeTo(average, 0.01)
            statistic.isSatisfyCondition() == satisfyCondition
            statistic.getSize() == size
            statistic.getMinimum() == minimum
            statistic.getMaximum() == maximum
        where:
            input                  | minimum | maximum | size | average   | satisfyCondition
            [6, 9, 15, -2, 92, 11] | -2      | 92      | 6    | 21.833333 | true
            [1, 2, 3, 4, 5, 6]     | 1       | 6       | 6    | 3.5       | false
            [21]                   | 21      | 21      | 1    | 21        | false
            []                     | 0       | 0       | 0    | 0         | false
            null                   | 0       | 0       | 0    | 0         | false
    }
}
