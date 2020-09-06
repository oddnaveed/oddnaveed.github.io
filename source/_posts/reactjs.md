---
title: React Learning
date: 2020-08-23 23:43:08
tags: [react, javascript, webDev]
categories: [software]
top: 9
visible:
---

# React via Handbook

To use react, add 2 script tags to the end of <body>

```html
<html>
  ...
  <body>
    ...
    <script src="https://cdnjs.cloudflare.com/ajax/libs/react/16.7.0-alpha.2/umd/react.developme
nt.js"
      crossorigin
    ></script>

    <script
src="https://cdnjs.cloudflare.com/ajax/libs/react-dom/16.7.0-alpha.2/umd/react-dom.p roduction.min.js"
      crossorigin
    ></script>
  </body>
</html>
```


- variables in JavaScript do not have any type attached
- it's suggested not to use var or let if we could use const
- Component name: capital letters with camel case
- in Class, access props via {this.props.variableName}

## Access Properties

```js [Function Based]
function HelloWorld(props) {
  return <h1>Hello {props.name}</h1>;
}
```


```js [Class Based]

class HelloWorld extends Component{
    render(){
        return (
            <h1>Hello {this.props.name}</h1>
        )
    }
}
```



## Transition
[React Spring](https://www.react-spring.io/)




















---

# React (Early 2020)

[认识 react](https://zh-hans.reactjs.org/tutorial/tutorial.html)

> 在 JavaScript class 中，每次你定义其子类的构造函数时，都需要调用 super 方法。因此，在所有含有构造函数的的 React 组件中，构造函数必须以 super(props) 开头。

<!--more-->

```javaScript
class Square extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      value: null,
    };
  }

  render() {
    return (
      <button className="square" onClick={() => alert('click')}>
        {this.props.value}
      </button>
    );
  }
}
```

> 因为 DOM 元素'button'是一个内置组件，因此其 onClick 属性在 React 中有特殊的含义。而对于用户自定义的组件来说，命名就可以由用户自己来定义了。我们给 Square 的 onClick 和 Board 的 handleClick 赋予任意的名称，代码依旧有效。在 React 中，有一个命名规范，通常会将代表事件的监听 prop 命名为 on[Event]，将处理事件的监听方法命名为 handle[Event] 这样的格式。

<br />

## 修改数据

### directly

```javaScript
var player = {score: 1, name: 'Jeff'};
player.score = 2;
// player 修改后的值为 {score: 2, name: 'Jeff'}
```

<br />

### new data replace old data 新数据替换旧数据

```javaScript
var player = {score: 1, name: 'Jeff'};
var newPlayer = Object.assign({}, player, {score: 2});
// player 的值没有改变, 但是 newPlayer 的值是 {score: 2, name: 'Jeff'}

// 使用对象展开语法，就可以写成：
var newPlayer = {...player, score: 2};
```

<br />

- 在 React 应用中，数据通过 props 的传递，从父组件流向子组件
- 我们用 state 来实现所谓“记忆”的功能
- 每次你定义其子类的 constructor 构造函数时，都需要调用 super 方法。因此，在所有含有 constructor 构造函数的的 React 组件中，构造函数 constructor 必须以 super(props) 开头
  `super(props);`
- 调用了 .slice() 方法创建了 squares 数组的一个副本，而不是直接在现有的数组上进行修改
- 如果你想写的组件只包含一个 render 方法，并且不包含 state，那么使用 function 函数组件就会更简单。我们不需要定义一个继承于 React.Component 的类，我们可以定义一个函数，这个函数接收 props 作为参数，然后返回需要渲染的元素。函数组件写起来并不像 class 组件那么繁琐，很多组件都可以使用函数组件 function 来写。

---

```javaScript JSX
const JSX =
<div>
    <h1>text</h1>
    <p></p>
    <ul>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>;
```

```javaScript [JSX comment]
const JSX = (
  <div>
    <h1>This is a block of JSX</h1>
    <p>Here's a subtitle</p>
    {/* comment comment comment
    */}
  </div>
);
```

---

JSX: a syntax extension of JavaScript

```javaScript [self-closing JSX tags]
const JSX = (
  <div>
    <h2>Welcome to React!</h2> <br />
    <p>Be sure to close all tags!</p>
    <hr />
  </div>
);
```

---

React requires your function name to begin with a capital letter:

```javaScript [stateless functional component]
// After being transpiled, the <div> will have a CSS class of 'customClass'
const DemoComponent = function() {
  return (
    <div className='customClass' />
  );
};
```

<br />

```javaScript [Create a component with composition]
const ChildComponent = () => {
  return (
    <div>
      <p>I am the child</p>
    </div>
  );
};

class ParentComponent extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <div>
        <h1>I am the parent</h1>
        <ChildComponent />
      </div>
    );
  }
};
```

```javaScript [Write a react component from scratch]
class MyComponent extends React.Component {
    constructor(props){
        super(props);
    }

    render(){
        return(
            <div>
                <h1>My First React Component!</h1>
            </div>
        )};
}

ReactDOM.render(<MyComponent />, document.getElementById('challenge-node'));
```

```javaScript [Pass props to a stateless functional component]
const CurrentDate = (props) => {
  return (
    <div>
      <p>The current date is: {props.date}</p>
    </div>
  );
};

class Calendar extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <div>
        <h3>What date is it?</h3>
        <CurrentDate date={Date()} />
      </div>
    )
  }
}
```

```javaScript [pass an array as props]
const List = (props) => {
  return <p>{props.tasks.join(",")}</p>
};

class ToDo extends React.Component {
  constructor(props){
    super(props);
  }
  render() {
    return (
      <div>
        <h1>To Do Lists</h1>
        <h2>Today</h2>
        <List tasks={["eat", "write", "sleep"]}/>
        <h2>Tomorrow</h2>
        <List tasks={["eat", "read", "sleep"]}/>
      </div>
    )
  }
}
```

```javaScript [Use Default Props]
const ShoppingCart = (props) => {
  return (
    <div>
      <h1>Shopping Cart Component</h1>
    </div>
  )
};

ShoppingCart.defaultProps = {items: 0}
```

```javaScript [Override default props]
const Items = (props) => {
  return <h1>Current Quantity of Items in Cart: {props.quantity}</h1>
}

Items.defaultProps = {
  quantity: 0
}

class ShoppingCart extends React.Component {
  constructor (props) {
    super(props);
  }

  render() {
    return <Items quantity={10}/>
  }
}
```

```javaScript [define propType]
const Item = (props) => {
  return <h1>Current Quantity of Items in Cart:
  {props.quantity}</h1>
};

Item.propTypes = {quantity: PropTypes.number.isRequired}

Items.defaultProps = {
  quantity: 0
;}

class ShoppingCart extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return <Items />
  }
};
```

```javaScript [Access props using this.props]
class ReturnTempPassword extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
      return (
        <div>
          <p>Your temporary password is:
            <strong>{this.props.tempPassword}</strong>
          </p>
        </div>
    )
  }
}

class ResetPassword extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return(
      <div>
        <h2>Reset Password</h2>
        <h3>We've generated a new temporary password for you.</h3>
        <h3>Please reset this password from your account settings ASAP.</h3>
        <ReturnTempPassword tempPassword="12345687"/>
      </div>
    )
  }
}
```

<br />

A stateless functional component is any function you write which accepts props and returns JSX. A stateless component, on the other hand, is a class that extends React.Component
<br />

```javaScript [review using props with stateless functional components]
class Campsite extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <div>
        <Camper />
      </div>
    );
  }
};

const Camper = (props) => {
  return (
    <div>
      <p>{props.name}</p>
    </div>
  )
};

Camper.defaultProps = {name: 'CamperBot'}

Camper.propTypes = {name: PropTypes.string.isRequired}
```

```javaScript [create a stateful component]
class StatefulComponent extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      name: mila
    }
  }
  render() {
    return (
      <div>
        <h1>{this.state.name}</h1>
      </div>
    );
  }
}
```

- we can write JavaScript directly in render method before return

```javascript [render state in the user interface another way]
{
  /*  declare and initialize a variable in render method */
}
class MyComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "freeCodeCamp",
    };
  }
  render() {
    const name = this.state.name;
    return (
      <div>
        <h1>{name}</h1>
      </div>
    );
  }
}
```

```javascript
class MyComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "Initial State",
    };
    this.handleClick = this.handleClick.bind(this);
  }
  handleClick() {
    this.setState({ name: "React Rocks!" });
  }
  render() {
    return (
      <div>
        <button onClick={this.handleClick}>Click Me</button>
        <h1>{this.state.name}</h1>
      </div>
    );
  }
}
```

```javaScript [Bind 'this' to a class method]

```

`why sometimes we need to use 'this', sometimes don't?`

```javaScript [use state to toggle an element]
class MyComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      visibility: false
    };
    this.toggleVisibility = this.toggleVisibility.bind(this);
  }

  toggleVisibility() {
    this.setState((state) => ({
      visibility: !state.visibility
    }))
  }

  render() {
    if (this.state.visibility) {
      return(
        <div>
          <button onClick={this.toggleVisibility}>Click me</button>
          <h1>Now you see me!</h1>
        </div>
      )
    } else {
      return (
        <div>
          <button onClick={this.toggleVisibility}>Click me</button>
        </div>
      )
    }
  }
}
```

```javaScript [create a controlled form]
class MyForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      input: '',
      submit: '',
    };
  this.handleChange = this.handleChange.bind(this);
  this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({
      input: event.target.value
    });
  }
  handleSubmit(event) {
    event.preventDefault();  {/* prevent default form submit behavior- auto-refreshing the page*/}
    this.setState({submit: this.state.input})
  }
  render() {
    return (
      <div>
        <form onSubmit={this.handleSubmit}>
        <input value={this.state.input} onChange = {this.handleChange}/>
        <button type='submit'>Submit!</button>
        </form>
        <h1>{this.state.submit}</h1>
      </div>
    )
}
```

```javaScript [pass state as props to child components]
class MyApp extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: 'CamperBot'
    }
  }
  render() {
    return (
      <div>
        <Navbar name={this.state.name} />
      </div>
    )
  }
};

class Navbar extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <div>
        <h1>Hello, this is: {this.props.name}</h1>
      </div>
    );
  }
};
```

```javaScript [use the lifecycle method componentDidMount]
class MyComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state ={
      activeUsers: null
    };
  }
  componentDidMount() {
    setTimeout(() => {
      this.setState({
        activeUsers: 1273
      });
    }, 2500);
  }
  render() {
    return (
      <div>
        <h1>Active Users: {this.state.activeUsers}</h1>
      </div>
    )
  }

}
```

```javascript [inline styles]
class Colorful extends React.Component {
  render() {
    return <div style={{ color: "red", fontSize: 72 }}>Big Red</div>;
  }
}
```

```javaScript [add inline styles in react]
const styles = {color: "purple", fontSize: 40, border: "2px solid purple"}

class Colorful extends React.Component {
  render() {
    return (
      <div style={styles}>Style Me!</div>
    );
  }
}
```

```javascript [use advanced javascript in react render method]
const inputStyle {
  width: 235,
  margin: 5
}

class MagicEightBall extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      userInput: '',
      randomIndex: ''
    }
    this.ask = this.ask.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }
  ask() {
    if (this.state.userInput) {
      this.setState({
        randomIndex: Math.floor(Math.random() * 20),
        userInput: ''
      });
    }
  }
  handleChange(event) {
    this.setState({
      userInput: event.target.value
    });
  }
  render() {
    const possibleAnswers = [
      'It is certain',
      'It is decidedly so',
      'Without a doubt',
      'Yes, definitely',
      'You may rely on it',
      'As I see it, yes',
      'Outlook good',
      'Yes',
    ];
    const answer = possibleAnswers[this.state.randomIndex]
    return (
      <div>
        <input
          type="text"
          value={this.state.userInput}
          onChange={this.handleChange}
          style={inputStyle} /><br />
        <button onClick={this.ask}>
          Ask the Magic Eight Ball
        </button><br />
        <h3>Answer:</h3>
        <p>{answer}
        </p>
      </div>
    );
  }
};
```

```javaScript [use && for conditional]
class MyComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      display: true
    }
    this.toggleDisplay = this.toggleDisplay.bind(this);
  }
  toggleDisplay() {
    this.setState(state => ({
      display: !state.display
    }));
  }
  render() {
    return (
      <div>
        <button onClick={this.toggleDisplay}>Toggle Display</button>
        {this.state.display && <h1>Displayed!</h1>}
      </div>
    );
  }
};
```

<br />

```javaScript [use a ternary expression for conditional rendering]
const inputStyle = {
  width: 235,
  margin: 5
}

class CheckUserAge extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      input:'',
      userAge:'',
    }
    this.submit = this.submit.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }
  handleChange(e) {
    this.setState({
      input:e.target.value,
      userAge: ''
    });
  }
  submit() {
    this.setState(state => ({
      userAge: state.input
    }));
  }
  render(){
    const buttonOne = <button onClick={this.submit}>Submit</button>;
    const buttonTwo = <button>You May Enter</button>;
    const buttonThree = <button>You Shall Not Pass</button>;
    return(
      <div>
        <h3>Enter Your Age to Continue</h3>
        <input
          style={inputStyle}
          type="number"
          value={this.state.input}
          onChange={this.handleChange} /><br />
          {this.state.userAge ==='' ?
          buttonOne :
            this.state.userAge<18 ? buttonThree : buttonTwo>}
      </div>
    );
  }
};
```

```javascript [render conditionally from props]
class Results extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <h1>
      {
        this.props.fiftyFifty === true ?
        "You Win!" :
        "You Lose!"
      }
      </h1>
    )
  };
};

class GameOfChance extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      counter: 1
    }
    this.handleClick = this.handleClick.bind(this);
  }
  handleClick() {
    this.setState({
      counter: this.state.counter + 1 ;
    })
  }
  render() {
    const expression = (Math.random() >= 0.5);
    return (
      <div>
        <button onClick={this.handleClick}>Play Again</button>
        <Result fiftyFifty={expression}/>
        <p>{'Turn: ' + this.state.counter}</p>
      </div>
    )
  }
}
```

```javaScript [using array.map() to dynamically render elements]
const textAreaStyles = {
  width: 235,
  margin: 5
}

class MyToDoList extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      userInput:'',
      toDoList: [],
    }
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }
  handleSubmit() {
    const itemsArray = this.state.userInput.split(',');
    this.setState({
      toDoList: itemsArray
    });
  }
  handleChange(e) {
    this.setState({
      userInput: e.target.value
    })
  }
  render() {
    const items = this.state.toDoList.map(i => <li>{i}</li>)
    return(
      <div>
        <textarea
          onChange={this.handleChange}
          value={this.state.userInput}
          style={textAreaStyles}
          placeholder="Separate Items With Commas"/>
        <br />
        <button onClick={this.handleSubmit}>Creat List</button>
        <h1>My "TO DO" List:</h1>
        <ul>
          {items}
        </ul>
      </div>
    )

  }
}
```

```javaScript
const frontEndFrameworks = [
  'React',
  'Angular',
  'Ember',
  'Knockout',
  'Backbone',
  'Vue'
];

function Frameworks() {
  const renderFrameworks = frontEndFrameworks.map((frontEndFramework,i) => <li key={i}>{frontEndFramework}</li>); // change code here
  return (
    <div>
      <h1>Popular Front End JavaScript Frameworks</h1>
      <ul>
        {renderFrameworks}
      </ul>
    </div>
  );
};
```

```javaScript [renderToString]
class App extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return <div/>
  }
};

ReactDOMServer.renderToString(<App />);
```

---

## Redux: state management framework

```javaScript []
const reducer = (state = 5) => {
  return state;
}

const store = Redux.createStore(reducer);
```

```javaScript [get state from the Redux Store]
const store = Redux.createStore(
  (state = 5) => state;
)

const currentState = store.getState();
```

```javaScript [Define an action creator]
const action = {
  type: 'LOGIN'
}

function actionCreator() {
  return action
}
```

```javaScript [Dispatch an action event]
const store = Redux.createStore(
  (state = {login: false}) => state
);

const loginAction = () => {
  return {
    type: 'LOGIN'
  }
};

store.dispatch(loginAction());
```

```javaScript [Handle an action in the store]
const defaultState = {
  login: false
};

const reducer = (state = defaultState, action) => {
  if(action.type === 'LOGIN'){
    return {
      login: true
    };
  } else {
    return state;
  }
}

const store = Redux.createStore(reducer);

const loginAction = () => {
  return {
    type: 'LOGIN'
  }
};
```

```javaScript [use a switch statement to handle multiple actions]
const defaultState = {
  authenticated: false
};

const authReducer = (state = defaultState, action) => {
  switch(action.type) {
    case 'LOGIN':
      return {
        authenticated: true
      }
    case 'LOGOUT':
      return {
        authenticated: false
      }
    default:
      return defaultState
  }
}

const store = Redux.createStore(authReducer);

const loginUser = () => {
  return {
    type: 'LOGIN'
  }
};

const logoutUser = () => {
  return {
    type: 'LOGOUT'
  }
}
```

```javascript [use const for action types]
const defaultState = {
  authenticated: false,
};

const authReducer = (state = defaultState, action) => {
  switch (action.type) {
    case LOGIN:
      return {
        authenticated: true,
      };
    case LOGOUT:
      return {
        authenticated: false,
      };
    default:
      return state;
  }
};

const store = Redux.createStore(authReducer);

const loginUser = () => {
  return {
    type: LOGIN,
  };
};

const logoutUser = () => {
  return {
    type: LOGOUT,
  };
};
```

```javaScript [combine multiple reducers]
const INCREMENT = 'INCREMENT';
const DECREMENT = 'DECREMENT';

const counterReducer = (state = 0, action) => {
  switch(action.type) {
    case INCREMENT:
      return state + 1;
    case DECREMENT:
      return state - 1;
    default:
      return state;
  }
};

const LOGIN = 'LOGIN';
const LOGOUT = 'LOGOUT';

const authReducer = (state = {authenticated: false}, action) => {
  switch(action.type) {
    case LOGIN:
      return {
        authenticated: true
      }
    case LOGOUT:
      return {
        authenticated: false
      }
    default:
      return state;
  }
};

const rootReducer = Redux.combineReducers({
  auth: authReducer,
  count: counterReducer
})// define the root reducer here

const store = Redux.createStore(rootReducer);

```

```javaScript [send action data to the store]
const ADD_NOTE = 'ADD_NOTE';

const notesReducer = (state = 'Initial State', action) => {
  switch(action.type) {
    case ADD_NOTE:
      return action.text;    // here!
    default:
      return state;
  }
};

const addNoteText = (note) => {
  return {
    type: ADD_NOTE,
    text: note  // text (property)
  }
}

const store = Redux.createStore(notesReducer);

console.log(store.getState());
store.dispatch(addNoteText('Hello!'));
console.log(store.getState());
```

- store creator
- action
- action creator
- dispatch an action
- a reducer function: after an action is created and dispatched, the Redux store needs to know how to respond to that action. A reducer takes state and action as arguments, and it always returns a new state
