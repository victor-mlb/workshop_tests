import spock.lang.Specification

class test extends Specification {

    def "should sum"() {
        given:
            def a = 1
            def b = 2
        when:
            def result = a + b
        then:
            result == 3
    }

}
