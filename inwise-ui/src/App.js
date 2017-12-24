import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  
  constructor() {
    super();

    this.state = {
      todos: [],
      currentTodo: ""
    };
  }

  onChange = e => {
    this.setState({currentTodo: e.target.value});
  }

  add = e => {
    
    let todosCopy = this.state.todos.slice();
    todosCopy.push(this.state.currentTodo);

    this.setState({todos: todosCopy, currentTodo: ""});
  }

  render() {

    let bulletedTodos = this.state.todos.map((e, i) => {
      return (
          <li key={i}>{e}</li>
        );
    });

    return (
        <div>
          <input placeholder="Enter todo here!" value={this.state.currentTodo} onChange={this.onChange}/>
          <button onClick={this.add}>Add</button>
          <br/>
          {this.state.todos.length == 0 ? "No ToDos yet!" : <ul>{bulletedTodos}</ul>}
        </div>
      );
  }
}

export default App;
