import React, { useState } from 'react';
import axios from 'axios';

const UpdateUserComponent = () => {
  const [userId, setUserId] = useState('');
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [phone, setPhone] = useState('');

  const handleUpdateUser = async () => {
    try {
      const response = await axios.put(`/api/users/${userId}`, {
        name,
        email,
        phone
      });
      console.log('Updated user:', response.data);
    } catch (error) {
      console.error('Error updating user:', error);
    }
  };

  return (
    <div className='container ' >
      <input type="text" placeholder="User ID" value={userId} onChange={(e) => setUserId(e.target.value)} />
      <br />  <br />
      <input type="text" placeholder="Name" value={name} onChange={(e) => setName(e.target.value)} />
      <br />  <br />
      <input type="text" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} />
      <br />  <br />
      <input type="text" placeholder="Phone" value={phone} onChange={(e) => setPhone(e.target.value)} />
      <br />  <br />
      <button onClick={handleUpdateUser}>Update User</button>
    </div>
  );
};

export default UpdateUserComponent;
