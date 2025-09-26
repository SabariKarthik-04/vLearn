import React, { useContext, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import { LoginRegisterContext } from './context/LoginRegisterProvider';

const Register = () => {
  const {setUser} = useContext(LoginRegisterContext)
  const nav = useNavigate();
  const [email, setEmail] = useState('')
  const [name, setName] = useState('')
  const [phone, setPhone] = useState('')
  const [dob, setDOB] = useState('')
  const [password, setPassword] = useState('')
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState('')
  const [success, setSuccess] = useState(false)

  // Validation helpers
  const validateEmail = (email) =>
    /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)
  const validatePhone = (phone) =>
    /^\d{10}$/.test(phone)
  const validatePassword = (password) =>
    password.length >= 6
  const validateDOB = (dob) => {
    // Accepts yyyy-mm-dd, must be at least 10 years old
    const date = new Date(dob)
    const now = new Date()
    const age = now.getFullYear() - date.getFullYear()
    return dob && !isNaN(date) && age >= 10
  }

  const handleSubmit = async (e) => {
    e.preventDefault()
    setError('')
    setSuccess(false)

    // Client-side validations
    if (!name.trim()) return setError('Name is required')
    if (!validateEmail(email)) return setError('Enter a valid email')
    if (!validatePassword(password)) return setError('Password must be at least 6 characters')
    if (!validatePhone(phone)) return setError('Phone must be 10 digits')
    if (!validateDOB(dob)) return setError('Enter a valid date of birth (at least 10 years old)')

    setLoading(true)
    try {
      // Replace with your actual API endpoint
      const response = await fetch('http://localhost:8080/auth/register', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name, email, password, phone, dob }),
      })
      if (response.status!=201) {
        const msg = await response.json();
        throw new Error(msg.msg || 'Registration failed')
      }
      const data = await response.json();
      setUser(data.user);
      setSuccess(true)
      setTimeout(() => nav('/adv-register'), 1500)
    } catch (err) {
      setError(err.message)
    } finally {
      setLoading(false)
    }
  }

  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gradient-to-br from-white via-blue-50 to-blue-100 px-2">
      <div className="bg-white shadow-xl rounded-2xl p-6 sm:p-8 w-full max-w-sm sm:max-w-md md:max-w-lg border border-blue-100 transition-all">
        <h2 className="text-2xl sm:text-3xl font-extrabold text-blue-700 mb-6 text-center tracking-tight">Create your vLearn Account</h2>
        <form onSubmit={handleSubmit} className="space-y-4 sm:space-y-6">
          <div>
            <label className="block text-gray-700 mb-1 font-semibold">Name</label>
            <input
              type="text"
              className="w-full px-3 py-2 border border-blue-200 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400 transition text-base"
              value={name}
              onChange={e => setName(e.target.value)}
              required
              autoFocus
              placeholder="Your full name"
            />
          </div>
          <div>
            <label className="block text-gray-700 mb-1 font-semibold">Email</label>
            <input
              type="email"
              className={`w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring-2 transition text-base ${
                email && !validateEmail(email) ? 'border-red-400 focus:ring-red-300' : 'border-blue-200 focus:ring-blue-400'
              }`}
              value={email}
              onChange={e => setEmail(e.target.value)}
              required
              placeholder="you@email.com"
            />
          </div>
          <div>
            <label className="block text-gray-700 mb-1 font-semibold">Password</label>
            <input
              type="password"
              className={`w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring-2 transition text-base ${
                password && !validatePassword(password) ? 'border-red-400 focus:ring-red-300' : 'border-blue-200 focus:ring-blue-400'
              }`}
              value={password}
              onChange={e => setPassword(e.target.value)}
              required
              placeholder="At least 6 characters"
            />
          </div>
          <div>
            <label className="block text-gray-700 mb-1 font-semibold">Phone No</label>
            <input
              type="tel"
              className={`w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring-2 transition text-base ${
                phone && !validatePhone(phone) ? 'border-red-400 focus:ring-red-300' : 'border-blue-200 focus:ring-blue-400'
              }`}
              value={phone}
              onChange={e => setPhone(e.target.value.replace(/\D/,''))}
              required
              maxLength={10}
              placeholder="10 digit number"
            />
          </div>
          <div>
            <label className="block text-gray-700 mb-1 font-semibold">Date Of Birth</label>
            <input
              type="date"
              className={`w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring-2 transition text-base ${
                dob && !validateDOB(dob) ? 'border-red-400 focus:ring-red-300' : 'border-blue-200 focus:ring-blue-400'
              }`}
              value={dob}
              onChange={e => setDOB(e.target.value)}
              required
              max={new Date().toISOString().split('T')[0]}
            />
          </div>
          {error && <div className="text-red-500 text-xs sm:text-sm text-center font-medium">{error}</div>}
          {success && <div className="text-green-600 text-xs sm:text-sm text-center font-medium">Registration successful! Redirecting...</div>}
          <button
            type="submit"
            className="w-full bg-gradient-to-r from-blue-500 to-blue-700 hover:from-blue-600 hover:to-blue-800 text-white font-bold py-2 rounded-lg shadow-lg transition disabled:opacity-60 text-base sm:text-lg"
            disabled={loading}
          >
            {loading ? 'Registering...' : 'Register'}
          </button>
        </form>
        <div className="mt-6 text-center text-gray-500 text-sm sm:text-base">
          Already have an account?{' '}
          <a href="/login" className="text-blue-600 hover:underline font-semibold">Login</a>
        </div>
      </div>
    </div>
  )
}

export default Register
