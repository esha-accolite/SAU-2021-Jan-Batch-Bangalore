import React from "react";
import ReactDOM from 'react-dom';

class Additions extends React.Component {
    constructor() {
        super();
        this.state = {name: 'TODOS'};
      }
    render() {
      return <h1>{this.state.name} ({this.props.Todos})</h1>;
    }
  }

export default Additions;