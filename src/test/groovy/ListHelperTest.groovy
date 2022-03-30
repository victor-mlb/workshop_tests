
import spock.lang.Specification
import spock.lang.Unroll

class ListHelperTest extends Specification {
    @Unroll
    def "should minimum value"(){
        when:
        def result = ListHelper.searchMinimum(value)
        then:
        result == expectedResult
        where:
        value                |  expectedResult
        [ 2,6,3,1]           |      1
        [ 20,60,30,10, 0,-80]|     -80
        []                   |      0
    }
    @Unroll
    def "should Maximum value"(){
        when:
        def result = ListHelper.searchMaximum(value)
        then:
        result == expectedResult
        where:
        value                |  expectedResult
        [ 2,6,3,1]           |      6
        [ 20,60,30,10, 0,-80]|     60
        []                   |      0
    }
    @Unroll
      def "should count Elements"(){
        when:
        def result = ListHelper.countElements(value)
        then:
        result == expectedResult
        where:
        value                |  expectedResult
        [ 2,6,3,1]           |      4
        [ 20,60,30,10, 0,-80]|      6
        []                   |      0
    }
    @Unroll
    def "should count Average"(){
        when:
        def result = ListHelper.countAverage(value)
        then:
        result == expectedResult
        where:
        value                 |  expectedResult
        [6, 9, 15, -2, 92, 11]|      21.833333
        [ 2,6,3,1]            |      3
        [ 20,60,30,10, 0,-80] |      6.666667
        []                    |      0
        [0,0,0,0,0]           |      0
    }
    @Unroll
  def "should valid Sequence"(){
        given:
        def result
        when:
        result = ListHelper.validSequence(value)
        then:
        result == expectedResult
        where:
        value                |  expectedResult
        [ 2,6,3,1]           |      false
        [ 20,60,30,10, 0, 80]|      true
        [ ]                  |      false
    }
    





}
