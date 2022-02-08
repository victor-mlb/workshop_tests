import spock.lang.Specification
import spock.lang.Unroll

class RemoveDuplicatedTest extends Specification {

    @Unroll
    def "should remove duplicate numbers of list"(){
        when:
            def result = RemoveDuplicated.removeDuplicate(listNumbers);
        then:
            result == resultExpected
        where:
            listNumbers     | resultExpected
            []              | []
            [1,1,3,4]       | [1,3,4]
            null            | []
            [1,2]           | [1,2]
    }

}
