import React from 'react';
import Navbar from './Components/Navbar';
import ListUsersComponent from './Components/ListUsersComponent';
import UpdateUserComponent from './Components/UpdateUserComponent';
import CreateClientComponent from './Components/CreateClientComponent';
import UpdateClientComponent from './Components/UpdateClientComponent';
function App() {
  return (
   <div>
      <Navbar/>
      <h1 className='text-secondary' >UserList</h1>
      <ListUsersComponent/>
      <hr></hr>
      <h1 className='text-danger'>Update User</h1>
      <UpdateUserComponent/>
      <hr></hr>
      <h1 className='text-warning'>Create Client</h1>
      <CreateClientComponent/>
      <hr></hr>
      <h1 className='text-success'>Update Client</h1>
      <UpdateClientComponent/>
   </div>
    
  );
}

export default App;
