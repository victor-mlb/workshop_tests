import spock.lang.Specification

class RemoveDuplicatedTest extends Specification {

    def "should remove duplicated"() {
        expect:
            RemoveDuplicated.removeDuplicate(list) == listResult
        where:
            list            ||  listResult
            null            ||  []
            []              ||  []
            [1,2]           ||  [1,2]
            [1,1,2,2,3,3]   ||  [1,2,3]
    }
}
