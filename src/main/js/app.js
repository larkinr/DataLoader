'use strict';

// tag::vars[]
const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');
// end::vars[]

// tag::app[]
class App extends React.Component { // <1>

    constructor(props) {
        super(props);
        this.state = {suites: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/ATCMT/SearchSuites'}).done(response => {
            this.setState({suites: response.entity._embedded.suites});
        });
    }

    render() {
        return (
            <SuiteList suite={this.state.suite}/>
        )
    }
}
// end::app[]

// tag::suite-list[]
class SuiteList extends React.Component{
    render() {
        const suites = this.props.suites.map(suite =>
            <Suite key={suite._links.self.href} suite={suite}/>
    );
        return (
            <table>
                <tbody>
                    <tr>
                        <th>Suite ID</th>
                        <th>Suite Name</th>
                        <th>Description</th>
                    </tr>
                    {suites}
                </tbody>
            </table>
    )
    }
}
// end::suite-list[]

// tag::suite[]
class Suite extends React.Component{
    render() {
        return (
            <tr>
                <td>{this.props.suite.testSuiteID}</td>
                <td>{this.props.suite.testSuiteName}</td>
                <td>{this.props.suite.description}</td>
            </tr>
    )
    }
}
// end::suite[]

// tag::render[]
ReactDOM.render(
<App />,
    document.getElementById('react')
)
// end::render[]