import React, { useContext } from 'react'
import { VlearnContext } from './context/VlearnProvider'
import Navbar from './components/Navbar';
import HeroSection from './components/HeroSection';
import HowItWorks from './components/HowItWorks';
import SkillCategoryGrid from './components/SkillCategoryGrid';
import CommunitySession from './components/CommunitySession';
import SmartSuggestions from './components/SmartSuggestions';
import CallToAction from './components/CallToAction';

const Home = () => {
  const {userData} = useContext(VlearnContext);
  const isLoggedIn = userData?true:false;
  return (
   <>
    <Navbar />
    <HeroSection />
      <HowItWorks />
      <SkillCategoryGrid />
      <CommunitySession />
      {isLoggedIn && <SmartSuggestions />}
      <CallToAction /> 
     
   </>
  )
}

export default Home
