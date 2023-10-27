import React from 'react';

import UserList from './UserList.jsx';

let titlePropType = (props, propName, componentName) => {
  if (props[propName]) {
    let value = props[propName];
    if (typeof value !== 'string' || value.length > 10) {
      console.log('error');
      return new Error(
        `${propName} en ${componentName} tiene más de 10 caracteres`
      );
    }
  }
}

const UserBox = React.createClass({
  loadUsers: function() {
    let data = [
      {id: "1",name: "Ricardo",email: "ricardo@banana.com"},
      {id: "2",name: "Juan",email: "juan@banana.com"},
      {id: "3",name: "Roberto",email: "roberto@banana.com"}
    ];

    this.setState({data: data});
  },

  getInitialState: function() {
    return {data: []};
  },

  componentDidMount: function() {
    this.loadUsers();
  },

  render: function() {
    return (
      <div className="UserBox">
        <nav>{this.props.headerProp}</nav>
        <h1>{this.props.title}-{this.props.id}</h1>
        <UserList data={this.state.data} />
        <div>{this.props.contentProp}</div>
      </div>
    );
  }
});

UserBox.defaultProps = {
   headerProp: "Header from props...",
   contentProp:"Content from props..."
}

UserBox.propTypes = {
  title: titlePropType,
  id: React.PropTypes.number.isRequired
};

export default UserBox;