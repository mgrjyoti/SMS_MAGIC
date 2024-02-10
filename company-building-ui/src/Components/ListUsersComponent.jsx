import React, { useState, useEffect } from 'react';
import axios from 'axios';

const ListUsersComponent = () => {
  const [users, setUsers] = useState([]);
  const [searchUsername, setSearchUsername] = useState('');

  useEffect(() => {
    fetchUsers();
  }, );

  const fetchUsers = async () => {
    try {
      const response = await axios.get('/api/users', {
        params: { username: searchUsername }
      });
      setUsers(response.data);
    } catch (error) {
      console.error('Error fetching users:', error);
    }
  };

  const handleSearch = (event) => {
    setSearchUsername(event.target.value);
  };

  return (
    <div className='container'>
      <input type="text" placeholder="Search by username" onChange={handleSearch} />
      <ul>
        {users.map(user => (
          <li key={user.id}>{user.name} - {user.email} - {user.phone}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListUsersComponent;
