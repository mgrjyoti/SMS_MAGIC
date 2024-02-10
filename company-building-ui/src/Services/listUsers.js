import axios from "axios";

const API_BASE_URL ='http://localhost:8080/user';
export const listUsers = async (username) => {
    try {
      const response = await axios.get(`${API_BASE_URL}/users`, {
        params: { username }
      });
      return response.data;
    } catch (error) {
      console.error('Error listing users:', error);
      throw error;
    }
  };