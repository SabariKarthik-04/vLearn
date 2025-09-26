import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const Login = () => {
  const nav =  useNavigate();
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState('')
  const [success, setSuccess] = useState(false)

  const handleSubmit = async (e) => {
    e.preventDefault()
    setLoading(true)
    setError('')
    setSuccess(false)
    try {
      const response = await fetch('http://localhost:8080/auth/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username:email, password }),
      })
      if (response.status!=200) {
        throw new Error('Invalid credentials')
      }
      const data = await response.text();
      localStorage.setItem("token",data);
      
      setSuccess(true)
      nav('/');
    } catch (err) {
      setError(err.message)
    } finally {
      setLoading(false)
    }
  }

  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gradient-to-br from-white via-blue-50 to-blue-100">
      <div className="bg-white shadow-xl rounded-2xl p-8 w-full max-w-md">
        <h2 className="text-3xl font-bold text-blue-700 mb-6 text-center">Welcome Back</h2>
        <form onSubmit={handleSubmit} className="space-y-5">
          <div>
            <label className="block text-gray-700 mb-1 font-medium">Email</label>
            <input
              type="email"
              className="w-full px-4 py-2 border border-blue-200 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400 transition"
              value={email}
              onChange={e => setEmail(e.target.value)}
              required
              autoFocus
            />
          </div>
          <div>
            <label className="block text-gray-700 mb-1 font-medium">Password</label>
            <input
              type="password"
              className="w-full px-4 py-2 border border-blue-200 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400 transition"
              value={password}
              onChange={e => setPassword(e.target.value)}
              required
            />
          </div>
          {error && <div className="text-red-500 text-sm text-center">{error}</div>}
          {success && <div className="text-green-600 text-sm text-center">Login successful!</div>}
          <button
            type="submit"
            className="w-full bg-blue-600 hover:bg-blue-700 text-white font-semibold py-2 rounded-lg shadow transition disabled:opacity-60"
            disabled={loading}
          >
            {loading ? 'Verifying...' : 'Login'}
          </button>
        </form>
        <div className="mt-6 text-center text-gray-500 text-sm">
          Don&apos;t have an account? <a href="/register" className="text-blue-600 hover:underline">Sign up</a>
        </div>
      </div>
    </div>
  )
}

export default Login
